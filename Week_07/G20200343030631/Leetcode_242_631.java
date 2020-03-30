/**
 * 解题思路: 根据题目限定范围，用一个长度26的map存放字符表，遍历一个字符串出现过的+1，遍历另一个字符串出现过的-1，
 * 最后检查map，存在负数或者不为0，即说明不是异或词
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * 执行用时 :11 ms, 在所有 Java 提交中击败了55.32%的用户
 * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了64.60%的用户
 * @Author: loe881@163.com
 * @Date: 2020/2/21
 */
public class Solution {

    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        if (null == s || null == t){
            return false;
        }
        if (s.length() != t.length()){
            return false;
        }
        int[] letterArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 减去'a'，转换为数字
            letterArr[s.charAt(i) - 'a'] ++;
            letterArr[t.charAt(i) - 'a'] --;
        }
        for (int i : letterArr) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
