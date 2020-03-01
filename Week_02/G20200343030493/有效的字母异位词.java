class Solution {
    public boolean isAnagram(String s, String t) {
        // 解法一 把把两个字符串顺序排列 然后看是否相等 O(nlogn)
        if (s.length() != t.length()) {
            return false;
        }
        // char toCharArray 把字符串转换为字符数组
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        // Arrays.sort()
        Arrays.sort( arr1 );
        Arrarys.sort( arr2 );
        // 判断是否相等 Arrays.equals 相等就返回 true
        return Arrays.equals(str1, str2);

    }

    class Solution {
        public boolean isAnagram(String s, String t) {
            // 解法二 哈希表
            if (s.length() != t.length()) {
                return false;
            }
            int[] counter = new int[26];
            for ( int i = 0; i < s.length(); i++) {
                // stirng.charAt() 通过索引查找某个字符在字符串中的位置
                // s 字符串相同的字符加1
                counter[s.charAt(i) - 'a']++;
                // t 字符串相同的字符加1
                counter[t.charAt(i) - 'a'] --;
            }
            // 如果发现count里面有一个字符的计数不是0，代表这个数是多出来的
            for (int count:counter) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
    }


