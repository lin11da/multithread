package controller.Other.Lambda_Expression;

/**
 * TODO
 *
 * @author chen
 * @version 1.0
 * @date 2021/10/28 19:14
 */
public class Lambda_Expression_Demo2 {
    public static void main(String[] args) {
//        ILove love = (int i) -> {
//            System.out.println("I love you  "+i);
//        };
//        love.love(9);

//        ILove love = (i) -> {                     //(i,x)
//            System.out.println("I love you  "+i);
//        };
//        love.love(9);

        ILove love = null;
        love = i -> System.out.println("I love you  "+i);
        /**
         * 这三个效果一样
         */

    }


}

interface ILove{
    void love(int i);
}
