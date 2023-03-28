package code.net.upload.demo02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Author: xl
 * date :2020/12/29 12:15
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
class ServerThread  implements Runnable{
    private Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            // 获取上传文件随机名称
            String fileName = "src\\" + System.currentTimeMillis() + new Random().nextInt(999999) + ".java";
            // 保存客户端上传的数据
            BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
            byte[] bys = new byte[1024];
            int len;
            while ((len = bis.read(bys)) != -1) {
                bos.write(bys, 0, len);
            }
            // 给客户端发出反馈信息
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();
            // 释放资源
            bos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        while (true) {
            Socket s = ss.accept();
            ServerThread serverThread = new ServerThread(s);
            new Thread(serverThread).start();
        }
    }
}

