package code.io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/12/29 11:00
 * description: 该类是文件和目录路径名的抽象表示
 *      构造方法：
 *
 * 方法	描述
 * public File(String pathname)	通过将给定的路径名字符串转换为抽象路径名来创建新的File实例
 * public File(String parent, String child)	从父路径名字符串和子路径名字符串创建新的File实例
 * public File(File parent, String child)	从父抽象路径名和子路径名字符串创建新的File实例
 * 成员方法：
 *
 * 创建功能：
 *
 * 方法	描述
 * public boolean createNewFile()	当具有该名称的文件不存在时，创建一个由该抽象路径名命名的新空文件
 * public boolean mkdir()	创建由此抽象路径名命名的单级目录
 * public boolean mkdirs()	创建由此抽象路径名命名的多级目录
 * 判断功能：
 *
 * 方法	描述
 * public boolean isDirectory()	测试此抽象路径名表示的File是否为目录
 * public boolean isFile()	测试此抽象路径名表示的File是否为文件
 * public boolean exists()	测试此抽象路径名表示的File是否存在
 * 获取功能：
 *
 * 方法	描述
 * public String getAbsolutePath()	返回此抽象路径名的绝对路径名字符串
 * public String getPath()	将此抽象路径名转换为路径名字符串
 * public String getName()	返回由此抽象路径名表示的文件或目录的名称
 * public String[] list()	返回此抽象路径名表示的目录中的文件和目录的名称字符串数组
 * public File[] listFiles()	返回此抽象路径名表示的目录中的文件和目录的File对象数组
 * 删除功能：
 *
 * 方法	描述
 * public boolean delete()	删除由此抽象路径名表示的文件或目录
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class FileDemo02 {
    //单级文件夹的复制
    public static void main(String[] args) throws IOException {
        File srcFolder = new File("D:\\sFolder");
        File destFolder = new File("D:\\dFolder");
        copyFolder(srcFolder, destFolder);
    }

    /**
     * 复制单级文件夹
     *
     * @param srcFolder  源文件夹
     * @param destFolder 目的文件夹
     * @throws IOException
     */
    private static void copyFolder(File srcFolder, File destFolder) throws IOException {
        // 判断路径是否存在
        if (!destFolder.exists()) {
            destFolder.mkdirs();
        }
        // 获取目的文件列表
        File[] listFiles = srcFolder.listFiles();
        // 遍历目的文件列表
        for (File file : listFiles) {
            copyFile(file, new File(destFolder, file.getName()));
        }
    }

    /**
     * 复制文件
     *
     * @param srcFile  源文件
     * @param destFile 目的文件
     * @throws IOException
     */
    private static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bos.close();
        bis.close();
    }

}
