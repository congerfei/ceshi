package code.ymal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ymaltest01 {

    public static void main(String[] args) {
        List<String> yaml = new ArrayList<>();
        yaml.add("redis.host.name");
        yaml.add("redis.aaa.bbb");
        yaml.add("redis.aaa.bbb.ccc");
        yaml.add("nacos.server.name");

        Object map = transListToLinkMap(yaml);
        System.out.println(map);
    }

    public static Object transListToLinkMap(List<String> yamlKey){
        Map<String,Object> linkMap = new LinkedHashMap();
        for (String val: yamlKey ) {
            Map<String,Object> map = (Map<String, Object>) transStringToLinkMap(val);
            addYamlMap(linkMap,map);
        }

        return linkMap;
    }

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




}
