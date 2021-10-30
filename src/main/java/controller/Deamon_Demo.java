package controller;

/**
 * TODO
 *  测试守护线程
 *  用户线程死亡了，守护线程也就死亡了
 * @author chen
 * @version 1.0
 * @date 2021/10/30 21:50
 */
public class Deamon_Demo {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认是false  表示用户线程  ，正常线程都是用户线程

        thread.start();//启动

        Thread thread1 = new Thread(you);

        thread1.start();
    }

}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("god life");
        }
    }
}

class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("good");
        }
        System.out.println("--goodbye");
    }
}