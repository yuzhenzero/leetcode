package com.leetcode;

import java.util.*;

// 56#, Medium
public class MergeIntervals {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare (Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public List<Interval> merge (List<Interval> intervals) {
        intervals.sort(new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || interval.start > merged.getLast().end) {
                // 如果没有重叠的部分，就直接加入
                merged.add(interval);
            } else {
                // 如果有重叠的部分，就先合并一下
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;
    }

}
