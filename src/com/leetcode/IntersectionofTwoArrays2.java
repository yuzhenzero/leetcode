package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
// 350#, Easy
public class IntersectionofTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> result = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length)
        {
            if (nums1[p1] < nums2[p2])
                p1++;
            else if (nums1[p1] > nums2[p2])
                p2++;
            else {
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;

    }

    public static void main(String[] args)
    {
        IntersectionofTwoArrays2 ita2 = new IntersectionofTwoArrays2();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(ita2.intersect(nums1, nums2)));
    }
}
