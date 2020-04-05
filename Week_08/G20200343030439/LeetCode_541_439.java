 
class Solution {
  public static void main(String[] args) {
    String s = "abcdefg";
    int k = 2;
    String result = reverseStr(s, k);

    System.out.println(result);
  }

  public static String reverseStr(String s, int k) {
    char[] arr = s.toCharArray();
    int n = arr.length;
    int i = 0;
    while (i < n) {
      int j = Math.min(i + k - 1, n - 1);
      swap(arr, i, j);
      i += 2 * k;
    }
    return String.valueOf(arr);
  }

  private static void swap(char[] arr, int l, int r) {
    while (l < r) {
      char temp = arr[l];
      arr[l++] = arr[r];
      arr[r--] = temp;
    }
  }
} 
