package com.dadisdad.coding;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 10308
 * @date 2020/3/7
 */
public class DuplicationInArray {

    public static int duplication(int[] nums) {
        int result = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result = nums[i];
                break;
            }
            map.put(nums[i], nums[i]);
        }
        return result;
    }

    public static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length ==0){
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                //swap
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0};
        System.out.println(duplication(null));
        System.out.println(findRepeatNumber(null));
    }
}
