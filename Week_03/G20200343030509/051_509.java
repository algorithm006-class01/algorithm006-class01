/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

class Solution {
  private Set<Integer> col = new HashSet<>();
  private Set<Integer> left = new HashSet<>();
  private Set<Integer> right = new HashSet<>();

  public List<List<String>> solveNQueens(int n) {
      List<List<String>> result = new ArrayList<>();
      dfs(result, new ArrayList<String>(), 0, n);
      return result;
  }

  private void dfs(List<List<String>> result, ArrayList<String> list, int row, int n) {
      if (row == n) { 
          result.add(new ArrayList<String>(list));
          return;
      }

      for (int i = 0; i < n; i++) {
          if (col.contains(i) || left.contains(row - i) || right.contains(row + i) ) continue;

          char[] charArray = new char[n];
          Arrays.fill(charArray, '.');
          charArray[i] = 'Q';
          String rowStr = new String(charArray);

          list.add(rowStr);
          col.add(i);
          left.add(row - i);
          right.add(row + i);

          dfs(result, list, row + 1, n);

          list.remove(list.size() - 1);
          col.remove(i);
          left.remove(row -i);
          right.remove(row + i);
      }
  }
}