package Array;

import java.util.Arrays;

/**
 * Date: 2022/03/16
 * Author: zhangyuyang
 * Description:
 */

public class Array_215 {
    // 先排序好
    public int findKthLargest_1(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums); // JDK 默认 快速排序
        return nums[len - k];
    }
}



