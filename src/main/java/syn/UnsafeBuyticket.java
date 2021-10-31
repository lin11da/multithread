package syn;

/**
 * TODO
 *
 * @author chen
 * @version 1.0
 * @date 2021/10/31 9:42
 */
public class UnsafeBuyticket {

    public static void main(String[] args) {
        Buyticket buyticket = new Buyticket();
        new Thread(buyticket,"哒哒").start();
        new Thread(buyticket,"33").start();
        new Thread(buyticket,"ff").start();
    }
}

class Buyticket implements Runnable{

    private int ticketNums = 10;
    boolean flag = true;        //外部停止方式

    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums<=0){
            flag = false;
            return;
        }

        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+" 拿到 "+ ticketNums--);
    }
}


