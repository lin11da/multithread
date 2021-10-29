package controller.Other;

/**
 * TODO
 *  静态代理模式总结： 真实（目标）对象都要实现同一个接口。代理对象要代理真实角色
 *  好处：代理对象可以做很多真实对象做不了的事情
 *  真实对象专注做自己的事情
 * @author chen
 * @version 1.0
 * @date 2021/10/28 18:30
 */
public class StacticProxy {
    public static void main(String[] args) {

        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}


interface Marry{

    void HappyMarry();
}

class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("准备进行");
    }
}

//代理角色
class WeddingCompany implements Marry{
    //代理谁》真实目标角色
    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();//这就是真实对象
        after();
    }



    private void before() {
        System.out.println("操作之前，初始化");
    }

    private void after() {
        System.out.println("进行完之后，结束");
    }
}