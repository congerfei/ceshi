package code.io.perproties;

import java.util.Properties;
import java.util.Set;

public class PerprotiesTest {

    public static void main(String[] args) {
        Properties prop = new Properties();

        // 存储元素
        prop.put("student1", "林青霞");
        prop.put("student2", "张曼玉");

        // 普通遍历
        Set<Object> keySet = prop.keySet();
        for (Object key : keySet) {
            Object value = prop.get(key);
            System.out.println(key + "," + value);
        }

        // 特有方法
        prop.setProperty("student3", "赵云");
        prop.setProperty("student4", "张飞");

        // 特有遍历
        Set<String> names = prop.stringPropertyNames();
        for (String key : names) {
            String value = prop.getProperty(key);
            System.out.println(key + "," + value);
        }
    }
}
