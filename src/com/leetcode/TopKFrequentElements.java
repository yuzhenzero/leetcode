package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 347#, Medium
public class TopKFrequentElements {
    public List<Integer> topKFrequent (int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Integer key : frequencyMap.keySet()) {
            int freq = frequencyMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        List<Integer> ans = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && ans.size() < k; pos--) {
            if (bucket[pos] != null) {
                ans.addAll(bucket[pos]);
            }
        }

        return ans;
    }

    public static void main (String[] args) {
        TopKFrequentElements tkfe = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(tkfe.topKFrequent(nums, 2));
    }
}
