package practical.K_recursion;

/**
 * Created by wWX945273 on 2021/5/21.
 题目2：汉诺塔问题
 打印 n 层汉诺塔从最左边移动到最右边的全部过程

 题目：在一根柱子上从下往上按照大小顺序摞着 n 片黄金圆盘。把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。并且规定，任何时候，
 在小圆盘上都不能放大圆盘，且在三根柱子之间一次只能移动一个圆盘。打印出移动次数最少的全过程。

 分析：
 给三根柱子分别命名为 “left”、“mid”、“right”，from 代表此次需要移动的圆盘所在的位置，to 代表这些圆盘要去的地方，help 是用于辅
 助的，分三步走：
 1、n-1 个圆盘从 from 到 help；
 2、第 n 个圆盘从 from 到 to；
 3、把那 n-1个圆盘从 help 移动到 to 上面来。
 时间复杂度：f(n) = 2f(n-1) +1，是2(n-1)

 */
public class Recursion_02 {
    public void hanoi(int n){
        if(n > 0){
            hanoiHelp(n, "a", "c", "b");
        }
    }

    private void hanoiHelp(int n, String from, String to, String help){
        if (n == 1){
            // 只有一个时，直接移到目标位置即可
            System.out.println(n + ":" + from + "->" + to);
            return;
        }
        // 下面是处理这个过程的递归问题，只用考虑当前n问题就行，不用尝试去理解它的子问题
        hanoiHelp(n-1, from, help, to); // 第1步：将n-1个圆盘从原位置移动到辅助位置
        System.out.println(n + ":" + from + "->" + to); // 第2步：将第n个圆盘移到目标位置，即打印即可
        hanoiHelp(n-1, help, to, from); // 第3步：将位置上的n-1个元素移到到目标位置
    }

    public static void main(String[] args) {
        Recursion_02 recursion_02 = new Recursion_02();
        recursion_02.hanoi(5);
    }
}
