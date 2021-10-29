package controller.Other;

import java.util.function.IntFunction;

/**
 * TODO
 *  模拟龟兔赛跑
 * @author chen
 * @version 1.0
 * @date 2021/10/28 16:11
 */
public class Demo6 implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            //给兔子线程做延时
            if (Thread.currentThread().getName().equals("兔子") &&i%10==0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //判断比赛是否结束
            boolean flag = gameOver(i);
            //如果比赛结束了就停止程序
            if (flag==true){
                break;
            }

            System.out.println(Thread.currentThread().getName()+"--跑了 "+i+" 秒");
        }
    }

    //判断是否完成比赛
    private boolean gameOver(int steps){
        //判断是否有胜利者
        if (winner!=null){  //已存在胜利者
            return true;
        }else if (steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is " +winner);
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        new Thread(demo6,"兔子").start();
        new Thread(demo6,"乌龟").start();
    }


}
