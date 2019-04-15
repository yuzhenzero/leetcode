package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 406#, Medium
public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue (int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare (int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1]:o2[0] - o1[0];
            }
        });

//        for (int[] person : people) {
//            System.out.println(Arrays.toString(person));
//        }

        List<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            queue.add(person[1],person);
        }

        return queue.toArray(new int[queue.size()][]);
    }

    public static void main (String[] args) {
        QueueReconstructionbyHeight qrh = new QueueReconstructionbyHeight();
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        for (int[] ints : qrh.reconstructQueue(people)) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
