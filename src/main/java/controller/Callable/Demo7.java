package controller.Callable;

import controller.Runnable.Demo4;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * TODO
 *  创建线程方式3 ： 实现Callable
 * @author chen
 * @version 1.0
 * @date 2021/10/28 16:23
 */
public class Demo7 implements Callable<Boolean> {
    private String url;
    private String name;

    public Demo7(String name,String url){
        this.name = name;
        this.url = url;
    }

    //下载图片线程的执行体
    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载的文件名为:"+name);
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo7 t1 = new Demo7("t1.jpg", "https://pic5.58cdn.com.cn/anjuke_58/f13c28345c2708bb6c7d1a75f4e36944?w=240&h=180&ss=1&crop=1&cpos=middle&w=240&h=180&crop=1&t=1&srotate=1");
        Demo7 t2 = new Demo7("t2.jpg", "https://pic5.58cdn.com.cn/anjuke_58/f13c28345c2708bb6c7d1a75f4e36944?w=240&h=180&ss=1&crop=1&cpos=middle&w=240&h=180&crop=1&t=1&srotate=1");
        Demo7 t3 = new Demo7("t3.jpg", "https://pic5.58cdn.com.cn/anjuke_58/f13c28345c2708bb6c7d1a75f4e36944?w=240&h=180&ss=1&crop=1&cpos=middle&w=240&h=180&crop=1&t=1&srotate=1");

        //创建执行服务:
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);

        //获取结果
        Boolean aBoolean1 = result1.get();
        Boolean aBoolean2 = result2.get();
        Boolean aBoolean3 = result3.get();

        //关闭服务
        ser.shutdownNow();

    }


}


//下载器
class WebDownloader {
    //下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}