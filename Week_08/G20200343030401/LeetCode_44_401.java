//题目链接：https://leetcode-cn.com/problems/wildcard-matching/

class Solution {
    public boolean isMatch(String s, String p) {
      int sLen = s.length(), pLen = p.length();
      if (p.equals(s) || p.equals("*")) return true;
      if (p.isEmpty() || s.isEmpty()) return false;
      boolean[][] d = new boolean[pLen + 1][sLen + 1];
      d[0][0] = true;
  
      for(int pIdx = 1; pIdx < pLen + 1; pIdx++) {
        if (p.charAt(pIdx - 1) == '*') {
          int sIdx = 1;
          while ((!d[pIdx - 1][sIdx - 1]) && (sIdx < sLen + 1)) sIdx++;
          d[pIdx][sIdx - 1] = d[pIdx - 1][sIdx - 1];
          while (sIdx < sLen + 1) d[pIdx][sIdx++] = true;
        }
        else if (p.charAt(pIdx - 1) == '?') {
          for(int sIdx = 1; sIdx < sLen + 1; sIdx++)
            d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1];
        }
        else {
          for(int sIdx = 1; sIdx < sLen + 1; sIdx++) {
            d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1] &&
                    (p.charAt(pIdx - 1) == s.charAt(sIdx - 1));
          }
        }
      }
      return d[pLen][sLen];
    }
  }
