package code.datasource;

import java.sql.*;

/**
 * Author: xl
 * date :2020/11/17 9:22
 * description:mysql元数据的获取,从连接中获取数据库的各种表数据
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class MysqlDatabaseMetaData {

    public static void main(String[] args) throws SQLException {
        //获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.137.100:3306/xl?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&nullCatalogMeansCurrent=true", "root", "123456");


        //通过连接获取元数据,就可以使用它的方法来获取数据库得信息
        DatabaseMetaData dbmd = conn.getMetaData();

        //获得当前数据库以及驱动的信息
        //
        //        dbmd.getDatabaseProductName()：用以获得当前数据库是什么数据库。比如oracle，access等。返回的是字符串。
        //        dbmd.getDatabaseProductVersion()：获得数据库的版本。返回的字符串。
        //        dbmd.getDriverVersion()：获得驱动程序的版本。返回字符串。
        //        dbmd.getTypeInfo() ：获得当前数据库的类型信息

        //getTables()返回结果集合ResultSet ，结果集中有5列
        ResultSet tables = dbmd.getTables(null, null, null, new String[]{"table"});
        while (tables.next()) {

            System.out.println(tables.getString("TABLE_NAME") + "  "
                    + tables.getString("TABLE_TYPE"));


            ResultSet rs = dbmd.getPrimaryKeys(null, null, tables.getString(3));
            while (rs.next()) {
                // 1.TABLE_CAT String => table catalog (may be null)
                String tableCat = rs.getString(1);

                // 2.TABLE_SCHEM String => table schema (may be null)
                String tableSchem = rs.getString(2);

                // 3.TABLE_NAME String => table name
                String tableName = rs.getString(3);

                // 4.COLUMN_NAME String => column name
                String columnName = rs.getString(4);

                // 5.KEY_SEQ short => sequence number within primary key
                short keySeq = rs.getShort(5);

                // 6.PK_NAME String => primary key name (may be null)
                String pkName = rs.getString(6);

                System.out.println(tableCat + "\t" + tableSchem + "\t" + tableName + " \t" + columnName + "\t" + keySeq + "\t" + pkName);

            }
            rs.close();

        }


    }


}
