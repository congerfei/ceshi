package code.io.perproties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PerprotiesTest02 {

    public static void main(String[] args) throws IOException {
        // 把集合中的数据保存到文件
        myStore();
        // 把文件中的数据加载到集合
        myLoad();
    }

    private static void myStore() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("student1", "林青霞");
        prop.setProperty("student2", "张曼玉");
        FileWriter fw = new FileWriter("fw.txt");
        prop.store(fw, null);
        fw.close();
    }

    private static void myLoad() throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("fw.txt");
        prop.load(fr);
        fr.close();
        System.out.println(prop);
    }
}
