package code.io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/12/22 10:34
 * description: 多级文件夹的复制
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class FileDemo03 {
    public static void main(String[] args) throws IOException {
        File srcFolder = new File("D:\\sFolder");
        File destFolder = new File("D:\\dFolder");
        copyFolder(srcFolder, destFolder);
    }

    /**
     * 复制多级文件夹
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
            if (file.isDirectory()) {
                copyFolder(file, new File(destFolder, file.getName()));
            } else {
                copyFile(file, new File(destFolder, file.getName()));
            }
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
