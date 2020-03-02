/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

class Solution {
  public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
      HashMap<String,String> map = new HashMap<String,String>();
      map.put("2", "abc");
      map.put("3", "def");
      map.put("4", "ghi");
      map.put("5", "jkl");
      map.put("6", "mno");
      map.put("7", "pqrs");
      map.put("8", "tuv");
      map.put("9", "wxyz");
      
      letters(digits, 0, "", result, map);
      
      return result;
  }

  private void letters(String digits, int index, String str, List<String> result, HashMap<String, String> map) {
      if (index == digits.length()) {
          result.add(str);
          return;
      }

      String digit = digits.substring(index, index + 1);
      String temp = map.get(digit);
      for (int i = 0; i < temp.length(); i++) {
          letters(digits, index + 1, str + temp.charAt(i), result, map);
      }
  }
}