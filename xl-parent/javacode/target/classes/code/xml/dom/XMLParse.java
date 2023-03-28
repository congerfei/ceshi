package code.xml.dom;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class XMLParse {

    /**
     * 读取全部
     */
    @Test
    public void test1() {
        try {
            SAXReader domReader = new SAXReader();
            Document document = domReader.read(new File("bookstore.xml"));
            Element rootElement = document.getRootElement();
            List<Element> bookElements = rootElement.elements("book");
            for (Element bookElement : bookElements) {
                Attribute category = bookElement.attribute("category");
                String title = bookElement.element("title").getText();
                String author = bookElement.element("author").getText();
                String year = bookElement.element("year").getText();
                String price = bookElement.element("price").getText();
                System.out.println(Arrays.asList(category.getText(), title, author, year, price));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增一行
     */
    @Test
    public void test2() {
        try {
            SAXReader domReader = new SAXReader();
            Document document = domReader.read(new File("bookstore.xml"));
            Element rootElement = document.getRootElement();

            Element bookElement = rootElement.addElement("book");
            bookElement.addAttribute("category", "Hibernate");
            bookElement.addElement("title").addText("Learing Hibernate");
            bookElement.addElement("author").addText("caochenlei");
            bookElement.addElement("year").addText("1997");
            bookElement.addElement("price").addText("99.99");

            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("bookstore.xml"), OutputFormat.createPrettyPrint());
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一行
     */
    @Test
    public void test3() {
        try {
            SAXReader domReader = new SAXReader();
            Document document = domReader.read(new File("bookstore.xml"));
            Element rootElement = document.getRootElement();

            Node singleNode = rootElement.selectSingleNode("//book[@category='Hibernate']");
            rootElement.remove(singleNode);

            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("bookstore.xml"), OutputFormat.createPrettyPrint());
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改一行
     */
    @Test
    public void test4() {
        try {
            SAXReader domReader = new SAXReader();
            Document document = domReader.read(new File("bookstore.xml"));
            Element rootElement = document.getRootElement();

            Node singleNode = rootElement.selectSingleNode("//book[@category='WEB']");
            singleNode.selectSingleNode("title").setText("Learning JavaWeb");
            singleNode.selectSingleNode("author").setText("张三");
            singleNode.selectSingleNode("year").setText("2020");
            singleNode.selectSingleNode("price").setText("09.09");

            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("bookstore.xml"), OutputFormat.createPrettyPrint());
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
