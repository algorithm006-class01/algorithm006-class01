package Week_03;

import java.util.*;

public class Leetcode_874_001 {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return 0;
            }

            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();

            beginSet.add(beginWord);
            endSet.add(endWord);

            Map<String, Set<String>> dict = generateMap(wordList);
            Set<String> visited = new HashSet<>();

            visited.add(beginWord);
            visited.add(endWord);

            return bfs(beginSet, endSet, dict, visited, 1);
        }

        private int bfs(Set<String> beginSet, Set<String> endSet, Map<String, Set<String>> dict, Set<String> visited, int level) {
            Set<String> nextBeginSet = new HashSet<>();

            for (String str : beginSet) {
                int len = str.length();

                for (int i = 0; i < len; i++) {
                    String key = str.substring(0, i) + "*" + str.substring(i + 1, len);
                    Set<String> neighborDict = dict.get(key);

                    if (neighborDict == null) {
                        continue;
                    }

                    for (String neighbor : neighborDict) {
                        if (endSet.contains(neighbor)) {
                            return level + 1;
                        }

                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            nextBeginSet.add(neighbor);
                        }
                    }
                }
            }

            if (nextBeginSet.isEmpty()) {
                return 0;
            }

            if (nextBeginSet.size() > endSet.size()) {
                return bfs(endSet, nextBeginSet, dict, visited, level + 1);
            } else {
                return bfs(nextBeginSet, endSet, dict, visited, level + 1);
            }
        }

        private Map<String, Set<String>> generateMap(List<String> wordList) {
            Map<String, Set<String>> map = new HashMap<>();

            for (String str : wordList) {
                for (int i = 0; i < str.length(); i++) {
                    String key = str.substring(0, i) + "*" + str.substring(i + 1, str.length());

                    if (!map.containsKey(key)) {
                        map.put(key, new HashSet<>());
                    }

                    map.get(key).add(str);
                }
            }

            return map;
        }
    }
}
