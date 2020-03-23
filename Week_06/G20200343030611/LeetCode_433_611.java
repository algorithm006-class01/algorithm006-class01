package datast.twowaybfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_433_611 {

    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
            if (bank.length == 0) return -1;
            if (!bankSet.contains(end)) return -1;
            char[] baseGens = {'A', 'C', 'G', 'T'};
            Set<String> positive = new HashSet<>(Collections.singletonList(start));
            Set<String> negative = new HashSet<>(Collections.singleton(end));
            Set<String> tempSet = new HashSet<>();
            int count = 0;
            while (!positive.isEmpty() && !negative.isEmpty()) {
                if (positive.size() > negative.size()) {
                    Set<String> temp = new HashSet<>(positive);
                    positive = negative;
                    negative = temp;
                }
                for (String word : positive) {
                    char[] wordCharArray = word.toCharArray();
                    for (int i = 0; i < wordCharArray.length; i++) {
                        char oldGen = wordCharArray[i];
                        for (char gen : baseGens) {
                            wordCharArray[i] = gen;
                            String newWord = String.valueOf(wordCharArray);
                            if (negative.contains(newWord)) return ++count;
                            if (bankSet.contains(newWord)) {
                                bankSet.remove(newWord);
                                tempSet.add(newWord);
                            }
                        }
                        wordCharArray[i] = oldGen;
                    }
                }
                positive = new HashSet<>(tempSet);
                tempSet.clear();
                count++;
            }

            return -1;
        }
    }
}
