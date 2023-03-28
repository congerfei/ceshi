package util.qrcode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Author: xl
 * date :2019/12/12 16:38
 * description:二维码生成核心类
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class QrcodeUtil {

    public static void main(String[] args) {
        System.out.println("二维码生成ing......");
        QrcodeImg("https://pic.rmb.bdstatic.com/1530971282b420d77bdfb6444d854f952fe31f0d1e.jpeg","./xl-parent/javacode/test.png");//通过网站的图片
        QrcodeImg("薇薇，好漂亮哟","./xl-parent/javacode/test文字.png");
        System.out.println("二维码生成完成......");
    }

    /**
     *
     * @param content   读取填写的内容
     * @param imgPath  生成二维码的保存路径
     * @return
     */
    public static void QrcodeImg(String content,String imgPath){

        //实例化一个Qrcode对象
        Qrcode qrcode = new Qrcode();
        //设置二维码的排错率,18%空间存放错误信息
        qrcode.setQrcodeErrorCorrect('M');
        //编码
        qrcode.setQrcodeEncodeMode('B');
        //版本
        qrcode.setQrcodeVersion('7');

        //开始绘制二维码    -->画板,=宽度，高度，颜色
        int width = 300;
        int height = 300;
        BufferedImage bf = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //绘制工具
        Graphics2D gs = bf.createGraphics();
        //设置背景色 ，白色
        gs.setBackground(Color.WHITE);
        //设置绘制区域
        gs.clearRect(0,0,width,height);
        //设置画笔的颜色,黑色
        gs.setColor(Color.blue);


        //正式的绘制，根据内容绘制
        byte[] contentType = null;
        try {
            contentType = content.getBytes("utf-8");//可能转换异常

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("内容转换异常");
        }

        //二维数组
        boolean[][] codesOut = qrcode.calQrcode(contentType);
        //拿到二维码里面所有的内容进行判断
        for (int i = 0;i< codesOut.length;i++){
            for (int j=0;j<codesOut.length;j++){
                if(codesOut[j][i]){
                    //绘制3*3矩形，并且距离（0，0）的距离是（10，20）
                    gs.fillRect(j*3+10,i*3+20,3,3);
                }
            }
        }

        //文件写出
        File imageFile = new File(imgPath);
        try {
            ImageIO.write(bf,"png",imageFile);//可能会抛异常
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
