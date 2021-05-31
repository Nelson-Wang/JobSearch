package practical.K_recursion;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wWX945273 on 2021/5/21.
 题目4：打印一个字符串的全部排列
 4.1 打印一个字符串的全部排列【每个结点i：有i~n-1种选择，之后的随意排序】

 你也可以同题目三一样用pre，思想是一样的，这里的i有 n-i 总选择，而题目三因为求的是子序列，只有 2 种选择【要或者不要】。
 差别：题目三不是所有字母都在，而且字母建不能乱序，所以不能用打印chars这种方法，而要用额外的pre来记录。

 */
public class Recursion_04 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] visited = new int[nums.length];
        help(res, temp, nums, visited);
        return res;

    }

    public void help(List<List<Integer>> res, List<Integer> temp, int[] nums, int[] visited){
        for (int i = 0; i < nums[i]; i++){
            if (visited[i] == 0){
                visited[i] = 1;
                temp.add(nums[i]);
                help(res, temp, nums, visited);
                visited[i] = 0;
                temp.remove(temp.size()-1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i =0; i < list.size(); i++){
            list.add(temp.get(i));
        }
        res.add(list);
    }

    public static void main(String[] args) {
        Recursion_04 recursion_04 = new Recursion_04();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsetsWithDup = recursion_04.subsetsWithDup(nums);
        System.out.println(subsetsWithDup);
    }
}
