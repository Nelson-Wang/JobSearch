package practical.K_recursion;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wWX945273 on 2021/5/21.
 题目3：打印一个字符串的全部子序列，包括空字符串

 每个结点 i：有 要 和 不要 两种选择，之后的随意选择要或不要

 子序列顺序不能变
 输入：
 abc
 输出：
 // 第一个是空串
 c
 b
 bc
 a
 ac
 ab
 abc

 */
public class Recursion_03 {
    public List<String> subsets(char[] chars) {
        List<String> res = new ArrayList<>();
        String temp = "";
        help(res, 0, temp, chars);
        return res;
    }
    public void help(List<String> res, int pos, String temp, char[] chars){
        // 已经到数组最后一个字符了，所有的选择都做完了，该返回了
        if (pos == chars.length){
            res.add(temp);
            return;
        }
        // 如果没有到最后一个字符，那么当前字符两种选择：选择要或者选择不要
        help(res, pos+1, temp+chars[pos], chars); // 要当前字符
        help(res, pos+1, temp, chars);  // 不要当前字符
    }

    public static void main(String[] args) {
        Recursion_03 recursion_03 = new Recursion_03();
        char[] chars = {'1', '2', '3'};
        List<String> subsets = recursion_03.subsets(chars);
        System.out.println(subsets);
    }
}
