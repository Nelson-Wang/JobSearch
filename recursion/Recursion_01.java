package practical.K_recursion;

/**
 * Created by wWX945273 on 2021/5/21.
 题目1：求 n! 的结果
 用递归去求解时：很明显求解 n! 其实就是求解 (n - 1)! 的问题，即它的子问题.....
 */
public class Recursion_01 {
    public long getFactorial2(int n){
        if (n == 1){
            return 1L;
        }

        return (long) n * getFactorial2(n-1);
    }

    public static void main(String[] args) {
        Recursion_01 recursion_01 = new Recursion_01();
        long factorial2 = recursion_01.getFactorial2(20);
        System.out.println(factorial2);
    }
}
