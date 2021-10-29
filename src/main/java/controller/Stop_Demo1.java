package controller;

/**
 * TODO
 *  线程停止
 * @author chen
 * @version 1.0
 * @date 2021/10/28 19:35
 */
public class Stop_Demo1 implements  Runnable{
    //设置一个标志位
    private boolean flag = true;
    @Override
    public void run() {
        int i =0;
        while (flag){
            System.out.println(Thread.currentThread().getName()+"run。。。。Thread "+i);
        }
    }

//    设置一个公开的方法停止线程，转换标志位
    public void stop(){
        this.flag = false;
    }


    public static void main(String[] args) {
        Stop_Demo1 stop_demo1 = new Stop_Demo1();
        new Thread(stop_demo1,"小打").start();

        for (int i = 0;i<1000;i++){
            System.out.println(":  " +i);
            if (i==900){
                stop_demo1.stop();
                System.out.println("线程停止");
            }
        }
    }
}
