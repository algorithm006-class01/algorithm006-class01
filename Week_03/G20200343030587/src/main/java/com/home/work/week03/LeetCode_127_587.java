package com.home.work.week03;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode_127_587 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        //双端队列
        LinkedList<String> sQueue = new LinkedList<>();
        LinkedList<String> eQueue = new LinkedList<>();

        Set<String> v1 = new HashSet<>();
        Set<String> v2 = new HashSet<>();
        sQueue.add(beginWord);
        eQueue.add(endWord);
        v1.add(beginWord);
        v2.add(endWord);

        int res = 0;
        while (!sQueue.isEmpty() && !eQueue.isEmpty()) {
            res++;
            if (sQueue.size() > eQueue.size()) {
                LinkedList<String> temp = sQueue;
                sQueue = eQueue;
                eQueue = temp;
                Set<String> v3 = v1;
                v1 = v2;
                v2 = v3;
            };
            for (int k = sQueue.size(); k > 0; k--) {
                String curr = sQueue.pop();
                for (int i = 0; i < wordList.size(); i++) {
                    if (v1.contains(wordList.get(i))) continue;
                    if (!diff(curr, wordList.get(i))) continue;
                    if (v2.contains(wordList.get(i))) return ++res;
                    sQueue.add(wordList.get(i));
                    v1.add(wordList.get(i));
                }
            }
        }
        return 0;
    }

    private boolean diff(String str, String str2) {
        int diff = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) != str2.charAt(j)) {
                if (++diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
