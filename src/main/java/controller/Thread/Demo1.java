package controller.Thread;

/**
 * TODO
 *
 * 创建线程方式一： 基础Thread类，重写run()方法，调用start开启线程
 *
 * 总结： 注意，线程开启不一定立即执行，由cpu调度执行
 * @author chen
 * @version 1.0
 * @date 2021/10/28 15:16
 */
public class Demo1 extends Thread{

    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在敲代码！"+i);
        }
    }


    public static void main(String[] args) {

        //创建线程对象
        Demo1 demo1 = new Demo1();
        //调用start方法执行线程
        demo1.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在睡觉！"+i);
        }
    }
}
