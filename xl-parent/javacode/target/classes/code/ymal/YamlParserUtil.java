package code.ymal;

import org.yaml.snakeyaml.Yaml;

import java.util.*;

public class YamlParserUtil {


    private static final Map<String,String> cacheYamlMap = new HashMap<>();

    public enum ConstantEnum{
        ADD("add"),

        REMOVE("remove");

        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        ConstantEnum(String code){
            this.code = code;
        }

        public static ConstantEnum getInstance(String code){
            for (ConstantEnum constantEnum: values()) {
                if(constantEnum.getCode().equals(code)){
                    return constantEnum;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        //加两个attr节点下属性，删addd属性
        String oldContent = "nacos:\n" +
                "  dg: 889990\n" +
                "  addd: 444\n" +
                "spring:\n" +
                "  redis:\n" +
                "    path: 3344\n";
        String newContent = "nacos:\n" +
                "  dg: 889990\n" +
                "spring:\n" +
                "  redis:\n" +
                "    path: 3344\n" +
                "    attr:\n" +
                "      name: 3333\n" +
                "      value: 4444";

        Yaml yaml = new Yaml();
        List<String> addAttr = YamlParserUtil.compareAndGetDiffAttr(oldContent, newContent, YamlParserUtil.ConstantEnum.ADD);
        List<String> removeAttr = YamlParserUtil.compareAndGetDiffAttr(oldContent, newContent, YamlParserUtil.ConstantEnum.REMOVE);
        Map<String,Object> addMap = (Map<String, Object>) YamlParserUtil.transListToLinkMap(addAttr);
        Map<String,Object> removeMap = (Map<String, Object>) YamlParserUtil.transListToLinkMap(removeAttr);

        Map originMap = yaml.loadAs(oldContent, Map.class);
        YamlParserUtil.addAndRemoveYaml(originMap,removeMap,addMap);
        String dump = yaml.dumpAsMap(originMap);
        System.out.println(dump);
    }

    /**
     * trans key list to map
     * demo: spring.redis.host to {spring={redis={host=}}}
     * @param yamlKey
     * @return
     */
    public static Object transListToLinkMap(List<String> yamlKey){
        Map<String,Object> linkMap = new LinkedHashMap();
        for (String val: yamlKey ) {
            Map<String,Object> map = (Map<String, Object>) transStringToLinkMap(val);
            addYamlMap(linkMap,map);
        }

        return linkMap;
    }

    public static void addAndRemoveYaml(Map<String,Object> originMap,Map<String,Object> removeMap,Map<String,Object> addMap){
        removeYamlMap(originMap,removeMap);
        addYamlMap(originMap,addMap);
    }

    public static boolean removeYamlMap(Map<String, Object> originMap, Map<String, Object> removeMap){
        for (Map.Entry<String,Object> val : removeMap.entrySet()) {
            for (Map.Entry<String,Object> obj :originMap.entrySet()) {
                if(val.getKey().equals(obj.getKey())){
                    try {
                        Map<String,Object> objVal = (Map<String,Object>) obj.getValue();
                        Map<String,Object> addVal = (Map<String,Object>) val.getValue();
                        if(removeYamlMap(objVal,addVal)){
                            originMap.remove(val.getKey());
                            break;
                        }
                    }catch (Exception e){
                        originMap.remove(val.getKey());
                        break;
                    }
                }
            }
        }
        if(originMap==null || originMap.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * {spring={redis={host=}}} | {spring={rabbit={host=}}} merge to {spring={redis={host=},rabbit={host=}}}
     *
     * Combine the addMap collection, do not allow the same key value to be overwritten
     * @param originMap
     * @param addMap
     */
    public static void addYamlMap(Map<String, Object> originMap, Map<String, Object> addMap){
        for (Map.Entry<String,Object> val : addMap.entrySet()) {
            boolean common = false;
            for (Map.Entry<String,Object> obj : originMap.entrySet()) {
                if (val.getKey().equals(obj.getKey())){
                    common = true;
                    try {
                        Map<String,Object> objVal = (Map<String,Object>) obj.getValue();
                        Map<String,Object> addVal = (Map<String,Object>) val.getValue();
                        addYamlMap(objVal,addVal);
                    }catch (Exception e){
                        break;
                    }
                    break;
                }
            }
            if(!common){
                originMap.put(val.getKey(),val.getValue());
            }
        }
    }

    /**
     * spring.redis.host to {spring={redis={host=}}}
     *
     * trans string to map，Parse the yaml string
     * @param val
     * @return
     */
    private static Object transStringToLinkMap(String val){
        int i = val.indexOf(".");
        if(i < 0){
            Map<String,Object> map = new LinkedHashMap<>();
            map.put(val,"");
            return map;
        }

        String key = val.substring(0, i);
        String value = val.substring(i + 1);
        Map<String ,Object> linkedHashMap = (Map<String, Object>) transStringToLinkMap(value);

        Map<String,Object> map = new LinkedHashMap<>();
        map.put(key,linkedHashMap);
        return map;
    }

    /**
     *
     * compare yaml content get diff key list
     * @param oldContent
     * @param newContent
     * @return
     */
    public static List<String> compareAndGetDiffAttr(String oldContent, String newContent,ConstantEnum type){
        Yaml yaml = new Yaml();
        Iterable<Object> oldYaml = yaml.loadAll(oldContent);
        List<String> oldKey = analyzeYamlToList(oldYaml);

        Iterable<Object> newYaml = yaml.loadAll(newContent);
        List<String> recent = analyzeYamlToList(newYaml);

        if(ConstantEnum.ADD.equals(type)){
            List<String> compareList = new ArrayList<>(recent);
            compareList.removeAll(oldKey);
            return compareList;
        }else{
            List<String> compareList = new ArrayList<>(oldKey);
            compareList.removeAll(recent);
            return compareList;
        }
    }

    public static List<String> analyzeYamlToList(Iterable<Object> newYaml){
        for (Iterator<Object> it = newYaml.iterator(); it.hasNext();){
            Map<String,Object> object = (Map<String, Object>) it.next();
            parseYamlToMap(object,null);
        }

        List<String> keyList = new ArrayList<>();
        cacheYamlMap.forEach((key,val)->{ keyList.add(key); });

        cacheYamlMap.clear();
        return keyList;
    }

    /**
     *  {spring={redis={host=},rabbit={host=}}} to {spring.redis.host= ,spring.rabbit.host=}
     *
     * trans yaml map to key map
     * @param item
     * @param key
     */
    public static void parseYamlToMap(Map<String, Object> item, String key){
        item.forEach((k,v) -> {
            if(Objects.isNull(v))
                if (key == null)
                    cacheYamlMap.put(k, "");
                else
                    cacheYamlMap.put(key.concat(".").concat(k), "");
            else if (v instanceof LinkedHashMap)
                if (key == null)
                    parseYamlToMap((Map<String, Object>) v,k);
                else
                    parseYamlToMap((Map<String, Object>) v,key.concat(".").concat(k));
            else
            if (key == null)
                cacheYamlMap.put(k, v.toString());
            else
                cacheYamlMap.put(key.concat(".").concat(k), v.toString());
        });
    }




}
