package com.leetcode;

import java.util.*;

// 127#, Medium
public class WordLadder {
    public int ladderLength (String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int N  = wordList.size();
        int start = N -1;
        int end = 0;
        while (end < N && !wordList.get(end).equals(endWord)) {
            end++;
        }
        if (end == N) // 字典中不存在目标词
            return 0;
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic,start,end);
    }

    private List<Integer>[] buildGraphic (List<String> wordList) {
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for (int i = 0; i < N; i++) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (isConnect(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    private boolean isConnect (String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length() && diff <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    private int getShortestPath (List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        queue.add(start);
        marked[start] = true;
        int pathLength = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int next : graphic[cur]) {
                    if (next == end) {
                        return pathLength;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    queue.add(next);
                    marked[next] = true;
                }
            }
        }
        return 0;
    }

    public static void main (String[] args) {
        WordLadder wl = new WordLadder();
        String[] strings = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(strings));
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(wl.ladderLength(beginWord,endWord,wordList));
    }
}
