package code.xml;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XMLUtil {


    public static void main(String[] args) {

        //测试 xml 转成 bean
        ConfigXL xl = (ConfigXL) convertXmlFileToObject(ConfigXL.class, "xl-parent/javacode/src/main/java/code/xml/config.xml");
        System.out.println(xl);

        //测试 String 转成 bean
        String xml = "<configuration id=\"begin\">\n" +
                "\n" +
                "    <!-- Site specific YARN configuration properties -->\n" +
                "    <property id=\"1\" >\n" +
                "        <name>yarn.resourcemanager.address</name>\n" +
                "        <value>localhost:8032</value>\n" +
                "    </property>\n" +
                "\n" +
                "    <property id=\"2\">\n" +
                "        <name>yarn.nodemanager.aux-services</name>\n" +
                "        <value>mapreduce_shuffle</value>\n" +
                "    </property>\n" +
                "    <property id=\"3\">\n" +
                "        <name>yarn.nodemanager.resource.memeory-mb</name>\n" +
                "        <value>1024</value>\n" +
                "    </property>\n" +
                "</configuration>";
        ConfigXL xmlxl = (ConfigXL) convertXmlStrToObject(ConfigXL.class, xml);
        System.out.println(xmlxl);

        //测试将对象转成 xml文件
        ConfigXL configXL = new ConfigXL();
        Property property1 = new Property();
        property1.setId("111");
        property1.setName("2222");
        property1.setValue("33333");
        Property property2 = new Property();

        Property property3 = new Property();
        List<Property> list = new ArrayList<>();
        list.add(property1);
        list.add(property2);
        list.add(property3);
        configXL.setPropertys(list);
        configXL.setId("beginxl");
        convertToXml(configXL, "xl-parent/javacode/src/main/java/code/xml/configxl.xml");




//        //该项目以ceshi路径开始为相对路径
//        Document dom = XMLUtil.load("xl-parent/javacode/src/main/java/code/xml/config.xml");
//        System.out.println(dom);  //org.dom4j.tree.DefaultDocument@5010be6
//
//
//        Element root = dom.getRootElement();//获取根节点对象
//        System.out.println(root); //org.dom4j.tree.DefaultElement@685f4c2e [Element: <configuration attributes: []/>]
//
//        Iterator iterator = root.elementIterator();//遍历得到3个节点
//        while(iterator.hasNext()) {
//            Node node = (Node) iterator.next();
//            //System.out.println(node);
//            if (node instanceof Element) {//节点元素
//                Element eleNode = (Element) node;
//                List<Attribute> attributes = eleNode.attributes();//得到该节点的所有属性
//                for (int i = 0; i < attributes.size(); i++) {
//                    System.out.println(attributes.get(i).getValue());
//                }
//
//            }
//            if (node instanceof Text) {
//                Text text = (Text) node;
//            }
//            if (node instanceof CDATA) {
//                CDATA dataNode = (CDATA) node;
//            }
//            if (node instanceof Comment) {
//                Comment comNode = (Comment) node;
//            }
//
//        }
    }


    public static Document load(String filename) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(filename)); // 读取XML文件,获得document对象
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return document;
    }

    public static Document load(URL url) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(url); // 读取XML文件,获得document对象
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return document;


    }

    /**
     * 将对象直接转换成String类型的 XML输出
     *
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    /**
     * 将对象根据路径写入指定的xml文件里
     *
     * @param obj
     * @param path
     * @return
     */
    public static void convertToXml(Object obj, String path) {
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 将对象转换成输出流形式的xml
            // 创建输出流
            FileWriter fw = null;
            try {
                fw = new FileWriter(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            marshaller.marshal(obj, fw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将String类型的xml转换成对象
     */
    public static Object convertXmlStrToObject(Class<?> clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshal = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshal.unmarshal(sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * 将file类型的xml转换成对象
     */
    public static Object convertXmlFileToObject(Class<?> clazz, String xmlPath) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStreamReader isr=new InputStreamReader(new FileInputStream(xmlPath),"GBK");
            xmlObject = unmarshaller.unmarshal(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlObject;
    }


}
