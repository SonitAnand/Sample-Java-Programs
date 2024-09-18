package org.example.sample1;

import java.util.Arrays;
import java.util.List;

public class LongestSubstringProgram {

    public static void main(String[] args) {

        //Given a string s, find the length of the longest substring without repeating characters.
        //Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
        //Input: s = "pwwkew" Output: 3
        //Explanation: The answer is "wke", with the length of 3. Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

        //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        //You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.
        //Input: nums = [2,7,11,15], target = 9
        //Output: [0,1]
        // Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        Integer[] nums = {2, 7, 4, 5, 11};
        int sum = 9;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == sum) {
                    System.out.println(i + "," + j);
                }
            }
        }
        System.out.println("-------------------------");
        List<Integer> list = Arrays.asList(nums);
        for (int i = 0; i < nums.length; i++) {
            int val = sum - nums[i];
            if (list.contains(val)) {
                System.out.println(i + "," + list.indexOf(val));
            }
        }

    }


}
