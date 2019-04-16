package com.leetcode;

// 744#, Easy
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter (char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }

    public static void main (String[] args) {
        FindSmallestLetterGreaterThanTarget fslgtt = new FindSmallestLetterGreaterThanTarget();
        char[] letters = {'c', 'f', 'j'};
        char target = 'k';
        System.out.println(fslgtt.nextGreatestLetter(letters,target));
    }
}
