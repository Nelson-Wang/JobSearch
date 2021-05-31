package practical.A_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wWX945273 on 2021/5/19.
 *
 题目：找出数组中出现次数大于数组长度 N/K 的数

 要求：时间复杂度为 O(NK)，额外空间复杂度为 O(K)。

 未解决

 */
public class Array_02 {
    public ArrayList<Integer> findOverKTimes(int[] arr, int k){
        int length = arr.length;

        HashMap<Integer, Integer> candiates  = new HashMap<>();
        for (int i = 0; i < length; i++){
            if (candiates.isEmpty() || !candiates.containsKey(arr[i]) && candiates.size() < k-1){
                candiates.put(arr[i], 1);
            }else if (candiates.containsKey(arr[i])){
                candiates.put(arr[i], candiates.get(arr[i]) + 1);
            }else {
                allCandiatesDeleteOne(candiates);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        if (!candiates.isEmpty()){

        }
        return list;

    }
    private void allCandiatesDeleteOne(HashMap<Integer, Integer> candiates){
        Set<Map.Entry<Integer, Integer>> entries = candiates.entrySet();
        for(Map.Entry<Integer, Integer> entry : entries){
            if (entry.getValue() > 0){
                candiates.put(entry.getKey(), entry.setValue(entry.getValue() - 1));
            }else {
                candiates.remove(entry.getKey());
            }
        }
    }
}
