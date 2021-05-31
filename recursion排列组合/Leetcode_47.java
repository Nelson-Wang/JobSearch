package practical.K_recursion.排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wWX945273 on 2021/5/25.

 Leetcode 47：全排列 II（最详细的解法！！！）

 给定一个可包含重复数字的序列，返回所有不重复的全排列。

 输入: [1,1,2]
 输出:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class Leetcode_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
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
            //前一个显示为未访问，且两个数相等则跳过不访问
            if (i != 0 && visited[i-1] == 0 && nums[i] == nums[i-1]){
                continue;
            }
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
        Leetcode_47 leetcode_47 = new Leetcode_47();
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = leetcode_47.permuteUnique(nums);
        System.out.println(res);
    }
}
