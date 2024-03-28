package com.everyday.leetcode;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-27 14:20
 **/
public class LC713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int left = 0, right = 0, n = nums.length, product = 1, count = 0;

        while (right < n) {
            product = product * nums[right];
            while (product >= k) {
                product = product / nums[left];
                left++;
            }
            count = count + 1 + (right - left);
            right++;
        }
        return count;

//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < k) {
//                sum++;
////                System.out.println(nums[i]);
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= k) {
//                continue;
//            }
//            int j = i + 1;
//            while (j < nums.length && nums[j] < k) {
//                j++;
//            }
//            j--;
//            if (i == j) {
//                continue;
//            }
//
//            while (i < j) {
//                int value = nums[i];
//                for (int l = i + 1; l <= j; l++) {
//                    value = value * nums[l];
//                    if (value >= k) {
//                        j = l - 1;
//                        break;
//                    }
//                }
//                if (value < k) {
//                    sum = sum + j - i;
//                    break;
//                }
//            }
//        }
//        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new LC713().numSubarrayProductLessThanK(new int[]{ 3, 3, 6, 2}, 19));
//        System.out.println(new LC713().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
