package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortCharactersByFrequency {
    public String frequencySort (String s) {
        HashMap<Character,Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (Character character : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(character);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList();
            }
            bucket[frequency].add(character);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] == null)
                continue;
            for (Character character : bucket[i]) {
                for (int j = 0; j < i; j++) {
                    ans.append(character);
                }

            }
        }
        return ans.toString();
    }

    public static void main (String[] args) {
        SortCharactersByFrequency scbf = new SortCharactersByFrequency();
        String s = "tree";
        System.out.println(scbf.frequencySort(s));
    }
}
