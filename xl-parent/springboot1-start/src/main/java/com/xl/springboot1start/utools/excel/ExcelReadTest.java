package com.xl.springboot1start.utools.excel;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Date;

/**
 * Author: xl
 * date :2020/12/6 17:34
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ExcelReadTest {

    /**
     * 获取某一个excel文件的第几个格子的数据
     * @throws Exception
     */
    @Test
    public void testRead0() throws Exception {
        //获取文件流
        FileInputStream inputStream = new FileInputStream("src/main/resources/流量统计表03.xls"); //FileInputStream的相对路径 是相对于src目录的
        //创建工作簿，excel的操作都有
        Workbook workbook = new HSSFWorkbook(inputStream);
        //得到表
        Sheet sheet = workbook.getSheetAt(0);
        //得到行
        Row row = sheet.getRow(0);
        //得到列
        Cell cell = row.getCell(0);

        //这里要注意的是 类型不同，我们要用不同的类型来接收
        System.out.println(cell.getStringCellValue());
         cell = row.getCell(1);
        System.out.println(cell.getNumericCellValue());

        inputStream.close();
    }

    /**
     *  通过文件得到文件的各个数据
     * @throws Exception
     */
    @Test //可以封装成一个方法，传入一个流就可以读出excel的文件了
    public void testCellType() throws Exception {
        //获取文件流
        FileInputStream inputStream = new FileInputStream("src/main/resources/产品.xls");
        //创建工作簿，excel的操作都有
        Workbook workbook = new HSSFWorkbook(inputStream);
        //得到表
        Sheet sheet = workbook.getSheetAt(0);
        //获取标题内容，也就是第一行的内容
        Row rowTitle = sheet.getRow(0);
        if(rowTitle!=null){
            //一定要掌握
            int cellCount = rowTitle.getPhysicalNumberOfCells();//获取标题行的列数
            //遍历，从0开始到标题行列数
            for(int cellNum = 0;cellNum < cellCount;cellNum++){
                Cell cell = rowTitle.getCell(cellNum);
                if(cell!=null){
                    CellType cellType = cell.getCellType();
                    String cellValue = cell.getStringCellValue();
                    System.out.print(cellValue+" | ");

                }
            }
        }

        System.out.println();


        //获取表中的内容
        //获取行的个数
        int rowCount = sheet.getPhysicalNumberOfRows();

        //第一行是标题，我们从第2行开始读取
        for(int rowNum = 1;rowNum<rowCount;rowNum++){
            Row rowData = sheet.getRow(rowNum);
            if(rowData != null){
                //读取列
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for(int cellNum = 0;cellNum < cellCount;cellNum++){
                    System.out.print("["+(rowNum+1)+"-"+(cellNum+1)+"]");
                    Cell cell = rowData.getCell(cellNum);
                    //匹配数据类型
                    if(cell != null){
                        CellType cellType = cell.getCellType();
                        String cellValue= "";
                        switch (cellType){
                            case STRING: //字符串
                                System.out.print("[String]");
                                cellValue = cell.getStringCellValue();
                                break;
                            case BOOLEAN://布尔
                                System.out.print("[boolean]");
                                cellValue = cell.getStringCellValue();
                                break;
                            case BLANK://空
                                System.out.print("[blank]");
                                break;
                            case NUMERIC://数字(日期，普通数字)
                                System.out.print("[numeric]");
                                if(HSSFDateUtil.isCellDateFormatted(cell)){//日期
                                    System.out.print("[日期]");
                                    Date date = cell.getDateCellValue();
                                    cellValue = new DateTime(date).toString("yyyy-MM-dd");
                                }else{
                                    //不是日期格式，防止数字过长！
                                    System.out.print("[转换成字符串输出]");
                                    cell.setCellType(CellType.STRING);
                                    cellValue = cell.toString();
                                }
                                break;
                            case ERROR:// 错误类型
                                System.out.print("[数据类型错误]");
                                break;
                        }
                        System.out.print(cellValue);
                        System.out.println();
                    }



                }
            }
        }

    }


}
