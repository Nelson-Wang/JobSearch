package practical.K_recursion.排列组合;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wWX945273 on 2021/5/26.

 Leetcode 17：电话号码的字母组合（最详细的解法！！！）

 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Leetcode_17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return res;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> strs = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++){
            char c = digits.charAt(i);
            String s = map.get(c);
            strs.add(s);
        }

        String temp = "";
        help(strs, 0, res, temp);
        return res;
    }

    public void help(List<String> strs, int strIndex, List<String> res, String temp){
        if (temp.length() == strs.size()){
            res.add(temp);
            return;
        }
        String str = strs.get(strIndex);
        for (int i = 0; i < str.length(); i++){
            help(strs, strIndex+1, res, temp + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        Leetcode_17 leetcode_17 = new Leetcode_17();
        List<String> res = leetcode_17.letterCombinations("");
        System.out.println(res);
    }
}
