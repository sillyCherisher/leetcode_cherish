package com.cherish.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Test8 {
//    这种解法是有重复的
    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> threeSum(int[] nums) {
//        if(nums == null || nums.length <= 2) return res;
//        helper(nums, 0, 0, new ArrayList<Integer>());
//        return res;
//    }
//
//    private void helper(int[] nums, int sum, int index, ArrayList<Integer> list) {
//        if(list.size() == 3 && sum == 0){
//            res.add(new ArrayList<>(list));
//            return;
//        }
//
//        for (int i = index; i < nums.length; i++) {
//            list.add(nums[i]);
//            helper(nums,sum + nums[i],i+1,list);
//            list.remove(list.size() - 1);
//        }
//    }

    // 解法二
    // 解题思路，固定一个数，二分查找
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) return res;
        Arrays.sort(nums);
        int sum = 0;
        int left;
        int right;
        for (int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]){
                left = i + 1;
                right = nums.length - 1;
                while (left < right){
                    sum = nums[i] + nums[left] + nums[right];
                    if(sum == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(new ArrayList<>(list));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }else if(sum < 0){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
