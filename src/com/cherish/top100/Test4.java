package com.cherish.top100;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class Test4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1 == 0){
            if(l2 % 2 == 1){
                return (double)(nums2[l2/2]);
            }else {
                return (nums2[l2/2 - 1] + nums2[l2/2])/2.0;
            }
        }

        if(l2 == 0){
            if(l1 % 2 == 1){
                return (double)(nums1[l1/2]);
            }else {
                return (nums1[l1/2 - 1] + nums1[l1/2])/2.0;
            }
        }

        int cur = 0;
        int i1 = 0;
        int i2 = 0;
        int mid = (l1 + l2)/2;
        int preNum = 0;
        int curNum = 0;
        while (cur <= mid){
            cur++;
            preNum = curNum;

            if(i1 == l1){
                curNum = nums2[i2++];
                continue;
            }

            if(i2 == l2){
                curNum = nums1[i1++];
                continue;
            }

            if(nums1[i1] <= nums2[i2]){
                curNum = nums1[i1++];
            }else {
                curNum = nums2[i2++];
            }
        }

        if((l1 + l2) % 2 == 1){
            return (double)curNum;
        }else {
            return (curNum + preNum)/2.0;
        }
    }
}
