package controller.Other.Lambda_Expression;

/**
 * TODO
 *
 * @author chen
 * @version 1.0
 * @date 2021/10/28 18:57
 */
//推导lambda表达式
public class Lambda_Expression_Demo1 {

    //3.静态内部类
    static class  Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();


        like = new Like2();
        like.lambda();



        //4.局部内部类
        class  Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        like = new Like3();
        like.lambda();


        //5.匿名内部类  没有类的名称  必须借助接口或父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();


        //6.用lambda简化
        like = ()->{
            System.out.println("I like lambda5");
        };
        like.lambda();
    }
}


//1.定义一个函数式接口
interface ILike{
    void lambda();
}

//实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}