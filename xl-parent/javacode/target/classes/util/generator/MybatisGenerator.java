package util.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

/**
 * Author: xl
 * date :2020/1/14 11:27
 * description:用于自动生成代码
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class MybatisGenerator {
    public void generator() throws Exception {
        ArrayList<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        // 指定你想工程配置文件
        File configFile = new File("javacode/src/main/resources/util/generator/generatorConfig-mysql.xml");
        System.out.println(configFile.getAbsolutePath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }

    public static void main(String[] args) throws Exception {
        MybatisGenerator mybatisGenerator = new MybatisGenerator();
        mybatisGenerator.generator();
    }

}
