import java.util.*;
/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */


// bfs 
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> wordSet = new HashSet<>(wordList);
//         if (!wordSet.contains(endWord)) return 0;
//         Queue<String> queue = new LinkedList<>();
//         queue.offer(beginWord);
//         wordSet.remove(beginWord);
//         int step = 0, wordLength = beginWord.length();
//         while (!queue.isEmpty()) {
//             step ++;
//             for (int i = queue.size(); i > 0; i --) {
//                 String word = queue.poll();
//                 for (Iterator<String> it = wordSet.iterator(); it.hasNext();) {
//                     String element = it.next();
//                     int diff = 0;
//                     for (int j = 0; j < wordLength; j ++) {
//                         if (word.charAt(j) != element.charAt(j))
//                             if (++diff > 1) break;
//                     }                   
//                     if (diff == 1) {
//                         if (endWord.equals(element))
//                             return step + 1;
//                         queue.offer(element);
//                         it.remove();
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
// }

// @date Mar 072020
// @solution bfs
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> dict = new HashSet<>(wordList);
//         if (!dict.contains(endWord)) return 0;
//         Queue<String> queue = new LinkedList<>();
//         queue.offer(beginWord);
//         dict.remove(beginWord);
//         int step = 0;
//         while (!queue.isEmpty()) {
//             step ++;
//             for (int i = queue.size(); i > 0; i --) {
//                 String word = queue.poll();
//                 for (int j = word.length() - 1; j >= 0; j --) {
//                     char[] letter = word.toCharArray();
//                     for (char alphabet = 'a'; alphabet <= 'z'; alphabet ++) {
//                         if (letter[j] == alphabet) continue;
//                         letter[j] = alphabet;
//                         String newWord = new String(letter);
//                         if (newWord.equals(endWord)) return step + 1;
//                         if (dict.contains(newWord)) {
//                             queue.offer(newWord);
//                             dict.remove(newWord);
//                         }
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
// }

// visited 是不需要的，从dict中减去word就可以了
// two-end bfs
// @date Mar 20 2020
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> dict = new HashSet<>(wordList);
//         Set<String> begin = new HashSet<>(), end =  new HashSet<>(), visited = new HashSet<>();
//         if (!dict.contains(endWord)) return 0;
//         int step = 1;
//         begin.add(beginWord);
//         end.add(endWord);

//         while(!begin.isEmpty() && !end.isEmpty()) {
//             if (begin.size() > end.size()) { // todo
//                 Set<String> set = begin;
//                 begin = end;
//                 end = set;
//             }
//             Set<String> temp = new HashSet<>();
//             for(String word : begin) {
//                 char[] letters = word.toCharArray();
//                 for(int i = 0; i < letters.length; i ++) {
//                     for (char alphabet = 'a'; alphabet <= 'z'; alphabet ++) {
//                         char c = letters[i];
//                         letters[i] = alphabet;
//                         String target = String.valueOf(letters);
//                         if (end.contains(target)) return step + 1;
//                         if (!visited.contains(target) && dict.contains(target)) {
//                             temp.add(target);
//                             visited.add(target);
//                         }
//                         letters[i] = c;
//                     }
//                 }
//             } 
//             begin = temp;
//             step ++;
//         }
//         return 0;
//     }
// }

// @lc code=start
// @date Mar 20 2020
// @solution two-end bfs best
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), temp = new HashSet<>();
        Set<String> front = new HashSet<>(), back = new HashSet<>();
        if (!dict.contains(endWord)) return 0;
        int step = 1;
        front.add(beginWord);
        back.add(endWord);
        dict.remove(beginWord);
        while(!front.isEmpty() && !back.isEmpty()) {
            if (front.size() > back.size()) { // todo
                temp = front;
                front = back;
                back = temp;
            }
            temp = new HashSet<>();
            for(String word : front) {
                for(int i = beginWord.length() - 1; i >= 0 ; i --) {
                    char[] letters = word.toCharArray();
                    for (char alphabet = 'a'; alphabet <= 'z'; alphabet ++) {
                        if (letters[i] == alphabet) continue;
                        letters[i] = alphabet;
                        String target = String.valueOf(letters);
                        if (back.contains(target)) return step + 1;
                        if (dict.contains(target)) {
                            temp.add(target);
                            dict.remove(target);
                        }
                    }
                }
            } 
            front = temp;
            step ++;
        }
        return 0;
    }
}
// @lc code=end

