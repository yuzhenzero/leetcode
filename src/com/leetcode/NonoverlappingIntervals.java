package com.leetcode;

// 435#, Medium

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals (Interval[] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare (Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        int count = 1;
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start<end) continue;
            end = intervals[i].end;
            count++;
        }

        return intervals.length - count;
    }
}
