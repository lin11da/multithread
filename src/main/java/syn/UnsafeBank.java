package syn;

/**
 * TODO
 *
 * @author chen
 * @version 1.0
 * @date 2021/10/31 10:39
 */
//不安全的取钱
    //两个人去银行取钱
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"银行");
        Drawing drawing = new Drawing(account, 50, "我");
        Drawing drawing2 = new Drawing(account, 100, "你 ");

       drawing.start();
       drawing2.start();
    }

}

//账户
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;
    String name;

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }


    @Override
    public void run() {
        if (account.money-drawingMoney<0){
            System.out.println(Thread.currentThread().getName()+"钱不够了");
            return;
        }
        //sleep可以放大问题的发生概率
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.money = account.money - drawingMoney;

        nowMoney = nowMoney + drawingMoney;

        System.out.println(Thread.currentThread().getName()+"手里的的钱"+nowMoney);

        System.out.println(account.name +"余额为："+account.money);

    }
}
