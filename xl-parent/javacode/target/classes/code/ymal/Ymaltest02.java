package code.ymal;

import org.yaml.snakeyaml.Yaml;

import java.util.*;

public class Ymaltest02 {


    private static final Map<String,String> cacheYamlMap = new HashMap<>();

    public static void main(String[] args) {
        String content = "global:\n" +
                "  resolve_timeout: null\n" +
                "  smtp_auth_password: null\n" +
                "  smtp_auth_username: null\n" +
                "  smtp_from: null\n" +
                "  smtp_require_tls: false\n" +
                "  smtp_smarthost: null\n" +
                "receivers:\n" +
                "- email_configs:\n" +
                "  - send_resolved: true\n" +
                "    to: 11433@qq.com\n" +
                "  name: email-demo\n" +
                "  webhook_configs:\n" +
                "  - url: http://128.96.1.11:8063/node/webhook\n" +
                "route:\n" +
                "  group_by:\n" +
                "  - alertname\n" +
                "  group_interval: 30s\n" +
                "  group_wait: 10s\n" +
                "  receiver: email-demo\n" +
                "  repeat_interval: 1h";

        Yaml yaml = new Yaml();
        Iterable<Object> oldYaml = yaml.loadAll(content);
        analyzeYamlToList(oldYaml);
        System.out.println(cacheYamlMap);
    }

    /**
     *   yaml字符串转非嵌套Map对象
     * @param newYaml
     */
    public static void analyzeYamlToList(Iterable<Object> newYaml){
        for (Iterator<Object> it = newYaml.iterator(); it.hasNext();){
            Map<String,Object> object = (Map<String, Object>) it.next();
            parseYamlToMap(object,null);
        }
    }

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
