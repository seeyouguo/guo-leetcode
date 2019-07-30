package main.com.guo;

import java.util.ArrayList;

/**
 *
 * 题目：两数之和
 * https://leetcode.com/problems/two-sum/

 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].


 *
 */
public class TowSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,8};
        twoSum(nums, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        java.util.List<Integer> list = new ArrayList<>();
        for(int i =0; i < nums.length; i ++){
            if(list.contains(nums[i])){
                return new int[]{list.indexOf(nums[i]), i};
            }else
                list.add(target - nums[i]);
        }
        return null;
    }

}
