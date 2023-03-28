package com.xl.springboot1start.utools.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/12/6 16:41
 * description:
 *  区别：
 *  03版本只支持65536行数据，过程中写入缓存，不操作磁盘，最后一次性写入磁盘，速度快   65536条数据大概2秒 ，超过65536会报错
 *  07版本支持打数据写入，比较慢65536条数据大概10s，
 *  还有一个对象 07版的加强对象  SXSSFWorkbook()，不带参数默认100，可以带参数 65536条只需要2秒不到，中间需要生成临时文件，关闭流后需要删除一下
 *      使用命令：(（SXSSFworkbook） workbook).dispose();
 *
 *
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ExcelWriteTest {

    //测试写入,如果使用07的只需要更换一个workbook对象为 new XSSFWorkbook();
    @Test
    public void testWriter03() throws IOException {
        //1.创建一个工作簿先用03版本的
        Workbook workbook = new HSSFWorkbook();//03版本的，.xls结尾，记得输出文件的格式要与该对象一致
        //Workbook workbook = new XSSFWorkbook();// 07版本的， .xlsx结尾，记得输出文件的格式要与该对象一致

        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("统计表");
        //3.创建一个行
        Row row1 = sheet.createRow(0);
        //4.创建一个单元格
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("今日新增观众数");
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(666);

        Row row2 = sheet.createRow(1);//第二行
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        Cell cell22 = row2.createCell(1);
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);

        //生成一张表，构建一个流  /开头就是D盘根目录去了， ../开头就是父项目springboot2-test的目录下了
        FileOutputStream fileOutputStream = new FileOutputStream("流量统计表03.xls");
        //FileOutputStream fileOutputStream = new FileOutputStream("流量统计表07.xlsx");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
        System.out.println("生成完毕！");



    }




}
