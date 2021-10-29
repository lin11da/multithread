package controller.Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * TODO
 * Thread 接口实现多线程
 * @author chen
 * @version 1.0
 * @date 2021/10/28 15:22
 */
public class Demo2 extends Thread{
    private String url;
    private String name;

    public Demo2(String name,String url){
        this.name = name;
        this.url = url;
    }

    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载的文件名为:"+name);
    }

    public static void main(String[] args) {
        Demo2 t1 = new Demo2("t1.jpg", "https://pic5.58cdn.com.cn/anjuke_58/f13c28345c2708bb6c7d1a75f4e36944?w=240&h=180&ss=1&crop=1&cpos=middle&w=240&h=180&crop=1&t=1&srotate=1");
        Demo2 t2 = new Demo2("t2.jpg", "https://pic5.58cdn.com.cn/anjuke_58/f13c28345c2708bb6c7d1a75f4e36944?w=240&h=180&ss=1&crop=1&cpos=middle&w=240&h=180&crop=1&t=1&srotate=1");
        Demo2 t3 = new Demo2("t3.jpg", "https://pic5.58cdn.com.cn/anjuke_58/f13c28345c2708bb6c7d1a75f4e36944?w=240&h=180&ss=1&crop=1&cpos=middle&w=240&h=180&crop=1&t=1&srotate=1");
        t1.start();
        t2.start();
        t3.start();
    }
}


//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
