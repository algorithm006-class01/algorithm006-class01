package com.jk.work.week06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LeetCode_433_587 {

    public int minMutation(String start, String end, String[] bank) {
        char[] arrs = new char[]{'A','C','G','T'};
        LinkedList<String> startQueue = new LinkedList<>();
        LinkedList<String> endQueue = new LinkedList<>();
        Set<String> set = new HashSet<String>(Arrays.asList(bank));
        if (!set.contains(end)) return -1;
        Set<String> v1 = new HashSet<String>();
        Set<String> v2 = new HashSet<String>();
        startQueue.add(start);
        endQueue.add(end);
        v1.add(start);
        v2.add(end);
        int step = 0;
        while (!startQueue.isEmpty()) {
            if (startQueue.size() > endQueue.size()) {
                LinkedList<String> t = startQueue;
                startQueue = endQueue;
                endQueue = t;
                Set<String> tv = new HashSet<String>();
                tv = v1;
                v1 = v2;
                v2 = tv;
            }
            String startStr = startQueue.pop();
            char[] chars = startStr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (int j = 0; j < arrs.length; j++) {
                    chars[i] = arrs[j];
                    String newString = new String(chars);
                    if (v1.contains(newString)) continue;
                    if (v2.contains(newString)) return ++step;
                    if (!set.contains(newString)) continue;
                    startQueue.add(newString);
                    v1.add(newString);
                }
                chars[i] = temp;
            }
            step++;
        }
        return -1;
    }
}
