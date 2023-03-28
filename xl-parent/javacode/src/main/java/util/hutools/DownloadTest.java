package util.hutools;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;

/**
 * Author: xl
 * date :2020/9/9 9:24
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class DownloadTest {

    public static void main(String[] args) {
        String fileUrl = "";

        HttpUtil.downloadFile(fileUrl, FileUtil.file("e:/"), new StreamProgress(){


            public void start() {
                Console.log("开始下载。。。。");
            }


            public void progress(long progressSize) {
                Console.log("已下载：{}", FileUtil.readableFileSize(progressSize));
            }

            public void finish() {
                Console.log("下载完成！");
            }
        });

    }

}
