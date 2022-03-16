package BinarySearch;

/**
 * Date: 2022/03/15
 * Author: zhangyuyang
 * Description:
 */
public class BinarySearch_704 {

    public static int search(int[] nums, int target) {
        // base case
        if (nums.length == 0) return -1;
        // begin and end
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else if (nums[mid] < target) begin = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1, 0, 3, 5, 9, 12};
        int out = search(test, 9);
        System.out.println(out);
    }
}
