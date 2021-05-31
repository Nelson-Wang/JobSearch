package practical.K_recursion.排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wWX945273 on 2021/5/25.

 Leetcode 77：组合（最详细的解法！！！）

 给定两个整数 n 和 k，返回 1 … n 中所有可能的 k 个数的组合。

 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Leetcode_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        help(res, list, n, k, 1);
        return res;
    }

    public void help(List<List<Integer>> res, List<Integer> list, int n, int k, int pos){
        if (list.size() == k ){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            res.add(temp);
            return;
        }
        for (int i = pos; i <= n; i++){
            list.add(i);
            help(res, list, n-(k-list.size()) + 1, k, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Leetcode_77 recusion_05 = new Leetcode_77();
        List<List<Integer>> res = recusion_05.combine(4, 2);
        System.out.println(res);
    }
}
