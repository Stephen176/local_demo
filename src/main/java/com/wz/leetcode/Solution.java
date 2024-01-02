package com.wz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * author: jiangtaihe
 * date: 2022/9/7
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(solution.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int third = len - 1;
            int target = -nums[i];
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < third && nums[j] + nums[third] > target) {
                    third--;
                }
                if (j == third) {
                    break;
                }
                if (nums[j] + nums[third] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[third]));
                }
            }
        }

        return result;
    }
}
