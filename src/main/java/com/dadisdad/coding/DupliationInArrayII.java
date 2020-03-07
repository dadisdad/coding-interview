package com.dadisdad.coding;

/**
 * @author 10308
 * @date 2020/3/7
 */
public class DupliationInArrayII {

    public static int findRepeat(int[] nums) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == newNums[nums[i]]) {
                return nums[i];
            }
            newNums[nums[i]] = nums[i];
        }
        return -1;
    }

    public static int findRepeatII(int[] nums) {
        int length = nums.length;
        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int mid = ((end - start) >> 1) + start;
            // 查找start -> mid 数组中数字出现的次数
            int count = countRange(nums, length, start, mid);
            if (end == start) {
                // 出现次数超过一次，则这个数字重复了
                if (count > 1) {
                    return start;
                }
            }
            // 判断在上半区还是下半区
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] nums, int length, int start, int end) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(findRepeat(nums));
        System.out.println(findRepeatII(nums));
    }
}
