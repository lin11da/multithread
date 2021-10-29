package controller;

/**
 * TODO
 * 
 * @author chen
 * @version 1.0
 * @date 2021/10/29 10:22
 */
public class Join_Demo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("VIP线程");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Join_Demo join_demo = new Join_Demo();
        Thread thread = new Thread(join_demo);

        thread.start();

        for (int i = 0; i < 40; i++) {
            if (i==10){
                //线程插队
                thread.join();
            }
            System.out.println("普通线程");
        }

    }
}
