package practical.A_array;

/**
 * Created by wWX945273 on 2021/5/18.

 题目：找出数组中出现次数大于数组长度一半的数

 要求：时间复杂的 O(N)，额外空间复杂度 O(1)

 分析：

 1、在数组中一次同时删掉两个不同的元素，如果存在某个数出现次数大于数组长度的一半，那么即使每次都删，最后也会至少剩下 1 个（不可
 能存在两个候选人，因为不可能存在两个数都超过一半）；

 2、 采用阵地攻守的思想：第一个数字作为第一个士兵即候选人 candiate，守阵地；candiate = 1 记录候选人个数；遇到相同元素，count++;
 遇到不相同元素，即为敌人，同归于尽，count- -；当遇到 count 为 0 的情况，又以新的 i 值作为守阵地的士兵，继续下去，到最后还留在
 阵地上的士兵，有可能是出现次数超过数组长度一半的元素。再遍历一次，确定这个士兵的个数看是否大于数组一半即可。

 *
 */
public class Array_01 {
    public int findOverHalfNum(int[] arr){
        int length = arr.length;
        int candicate = arr[0];
        int count = 1;
        for (int i = 1; i < length; i++){
            if (count == 0){
                candicate = arr[i];
                count = 1;
                continue;
            }
            if (arr[i] == candicate){
                count++;
            }else {
                count--;
            }
        }

        if (count!=0){
            count = 0;
            for (int j = 0; j < length; j++){
                if (candicate == arr[j]){
                    count++;
                }
            }
        }
        return count > length / 2? candicate: -1;
    }

    public static void main(String[] args) {
        Array_01 array_01 = new Array_01();
        int[] nums = {3, 1, 4, 1, 1, 1, 1, 7, 8, 1, 4, 1, 13, 1, 2};
        int i = array_01.findOverHalfNum(nums);
        System.out.println(i);
    }
}
