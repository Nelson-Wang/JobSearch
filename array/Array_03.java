package practical.A_array;

import java.util.Arrays;

/**
 * Created by wWX945273 on 2021/5/19.
 *
 题目：给定一个整型数组，请在原地调整这个数组，保证要么偶数位置上都是偶数，或者奇数位置上都是奇数。

 要求：时间复杂度 O(N)，额外空间复杂度 O(1)。

 这个题目需要注意的是：偶数在偶数的位置、奇数在奇数的位置，这两个条件满足其一就行了。
 将最后一个元素作为发货点，根据自己值的奇偶性和当前数组 odd 和 even 指针指向的元素进行交换，这样不停的交换。最后
 如果有一个指针越界了，那对应的规则就排在了对应的位置上了。

 */
public class Array_03 {
    public void getOrder(int[] arr){
        int length = arr.length;
        int even = 0; // 指向偶数的位置
        int odd = 1; // 指向奇数的位置
        // 发货点：每次把最后一个数根据它是奇数还是偶数和前面对应奇偶指针上的数互换位置
        int end = length-1;
        while (even < length && odd < length){
            if (arr[end] % 2 == 0){
                // 往even指针上发货,然后even指针后移两位
                swap(arr, end, even);
                even += 2;
            }else {
                // 往odd指针上发货,然后odd指针后移两位
                swap(arr, end, odd);
                odd += 2;
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        Array_03 array_03 = new Array_03();
        int[] nums = {2, 3, 1, 4, 21, 3, 1, 4, 24, 1};
        array_03.getOrder(nums);
        System.out.println(Arrays.toString(nums));
    }
}
