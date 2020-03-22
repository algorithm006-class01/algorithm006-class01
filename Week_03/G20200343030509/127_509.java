/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if (!wordList.contains(endWord)) {
          return 0;
      }

      Set<String> wordSet = new HashSet<>(wordList);
      Set<String> beginSet = new HashSet<>();
      Set<String> endSet = new HashSet<>();
      beginSet.add(beginWord);
      endSet.add(endWord);
      
      int step = 1;
      Set<String> visited = new HashSet<>();
      while (!beginSet.isEmpty() && !endSet.isEmpty()) {
          // 谁短先走谁
          if (beginSet.size() > endSet.size()) {
              Set<String> set = beginSet;
              beginSet = endSet;
              endSet = set;
          }
          Set<String> temp = new HashSet<String>(); 
          for (String word : beginSet) {
              char[] chars = word.toCharArray();

              // 每个字母替换
              for (int i = 0; i < chars.length; i++) {
                  for (char c = 'a'; c < 'z'; c++) {
                      char old = chars[i];
                      chars[i] = c;
                      String target = String.valueOf(chars);
                      
                      // 已经在end里面有了，接上了
                      if (endSet.contains(target)) {
                          return step + 1;
                      }
                      // 是不是在单词池里，并且没访问过
                      if (!visited.contains(target) && wordSet.contains(target)) {
                          temp.add(target);
                          visited.add(target);
                      }
                      chars[i] = old;
                  }
              }
          }
          beginSet = temp;
          step++;
      }
      return 0;
  }
}