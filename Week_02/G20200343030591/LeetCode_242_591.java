class Solution {
    /**
     * 题目：有效的字母异位词
     * 解法1：
     * 1、使用计数器来统计第一个字符串中 每个字母出现的频率
     * 2、第一个字符串 统计频率做加的操作，第二个字符串统计时候做减的操作
     * 3、最后查看这个计数器是否有不为0的元素
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 同上 写法不同而已
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int result = counter[t.charAt(i) - 'a']--;
            if ((result - 1) < 0) {
                return false;
            }
        }
        return true;
    }

}