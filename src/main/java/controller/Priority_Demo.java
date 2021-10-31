package controller;

/**
 * TODO
 *  测试线程的优先级
 * @author chen
 * @version 1.0
 * @date 2021/10/30 16:21
 */
public class Priority_Demo{

    public static void main(String[] args) {
        //主线程默认优先级
       System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());

        MyPriority_Demo myPriorityDemo = new MyPriority_Demo();

        Thread t1 = new Thread(myPriorityDemo,"小1");
        Thread t2 = new Thread(myPriorityDemo,"小2");
        Thread t3 = new Thread(myPriorityDemo,"小3");
        Thread t4 = new Thread(myPriorityDemo,"小4");

        //设置优先级再启动
        t1.start();

        t2.setPriority(1);
        t2.start();


        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();



    }



}

class MyPriority_Demo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());
    }
}
