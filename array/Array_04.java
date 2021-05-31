package practical.A_array;

/**
 * Created by wWX945273 on 2021/5/19.
 *
 题目：给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 示例 1:

 输入: [1, 2, 2, 3, 1]
 输出: 2
 解释:
 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 连续子数组里面拥有相同度的有如下所示:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 最短连续子数组[2, 2]的长度为2，所以返回2.
 示例 2:

 输入: [1,2,2,3,1,4,2]
 输出: 6

 思路：

 首先需要找到数组中出现次数最多的数，并且还需要知道它们在数组中第一次和最后一次出现的位置。需要注意的是出现次数最多的数可能并不
 唯一，那就需要比较它们在原数组中代表的子数组哪个小就取哪个。

 下面用桶实现，O(N) 的时间复杂度

 */
public class Array_04 {
    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        int max = nums[0];

        // 找到数组中最大元素的值
        for (int i = 1; i < length; i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }

        // 创建 max + 1 个桶
        int[] counts = new int[max + 1]; // 存储数组元素出现的次数
        int[] beginIndex = new int[max + 1];  // 存储元素的起始下标
        int[] endIndex = new int[max + 1]; // 存储元素的结束下标

        for (int i = 0; i < length; i ++){
            if (counts[nums[i]] == 0){
                beginIndex[nums[i]] = i;
            }
            counts[nums[i]]++;
            // 结束位置都是遇到就更新，这样就可以记录到最后一次出现的位置
            endIndex[nums[i]] = i;
        }

        // 查找元素出现次数最多(count[i]最大)，且长度最短（endIndex[i] - beginIndex[i]-1最小）的长度
        int maXCount = Integer.MIN_VALUE;
        int minSubLength = length;
        for (int j = 0; j < max + 1; j++){
            //找出更大的counts[i],或者counts[i]==maxCount但minSubLength更小的counts[i]
            if (counts[nums[j]] > maXCount || counts[nums[j]] == maXCount && endIndex[nums[j]]-beginIndex[nums[j]]+1 < minSubLength){
                maXCount = counts[nums[j]];
                minSubLength = endIndex[nums[j]]-beginIndex[nums[j]]+1;
            }
        }
        return minSubLength;
    }

    public static void main(String[] args) {
        Array_04 array_04 = new Array_04();
        int[] nums = {1, 2, 2, 3, 1};
        int i = array_04.findShortestSubArray(nums);
        System.out.println(i);
    }
}
