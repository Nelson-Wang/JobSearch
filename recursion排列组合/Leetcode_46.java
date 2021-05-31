package practical.K_recursion.排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wWX945273 on 2021/5/25.
 *
 Leetcode 46：全排列（最详细的解法！！！）

 给定一个没有重复数字的序列，返回其所有可能的全排列。

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Leetcode_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        help(res, list, nums, visited);
        return res;

    }

    public void help(List<List<Integer>> res, List<Integer> list, int[] nums, int[] visited){
        if (list.size() == nums.length){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            res.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (visited[i] == 0){
                visited[i] = 1;
                list.add(nums[i]);
                help(res, list, nums, visited);
                list.remove(list.size()-1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode_46 leetcode_46 = new Leetcode_46();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = leetcode_46.permute(nums);
        System.out.println(res);
    }
}
