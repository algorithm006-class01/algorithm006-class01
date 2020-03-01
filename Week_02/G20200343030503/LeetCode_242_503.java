/**
 *
 * 是否是异位词
 * 方式1. 排序(借助字符数组进行排序) 判断内容是否相同
 *       time complexity O(nlogn)
 *       space complexity O(n)
 *       如果isAnagram中两个参数是字符数组,那么space complexity O(1)
 * 方式2. 使用hash表来统计每个字符出现的次数
 *       time complexity O(n)
 *       space complexity O(1)
 * 总结:
 * 			第一种排序然后比较方便快捷,很容易想到 , 根据hash表统计字符出现的次数可以想到 ,
 *			第三种方式借助ASCII表统计字符出现的次数很难想到,看来官方题解和助教老师的帮助才理解来
 *			基础需要加强,仍然需要训练自己的思维能力
 *
 */
class Solution {
    // public boolean isAnagram(String s, String t) {
    //     char[] sarr = s.toCharArray();
    //     char[] tarr = t.toCharArray();
    //     Arrays.sort(sarr);
    //     Arrays.sort(tarr);
    //     boolean flag = Arrays.equals(sarr,tarr);
    //     if (flag) {
    //         return true;
    //     }
    //     return false;
    // }
    //这种方式具慢
    // public boolean isAnagram(String s, String t) {
    //     Map<Character,Integer> counter = new HashMap<Character,Integer>();
    //     for (int i = 0; i < s.length(); i++) {
    //         if (counter.containsKey(s.charAt(i))) {
    //             counter.put(s.charAt(i),counter.get(s.charAt(i))+1);
    //         } else {
    //             counter.put(s.charAt(i),1);
    //         }
    //     }
    //     for (int i = 0; i < t.length(); i++) {
    //         if (counter.containsKey(t.charAt(i))) {
    //             if (counter.get(t.charAt(i)) > 1) { //特别注意，如果只有个数只有1个 直接remove，如果是大于1需要减1
    //                 counter.put(t.charAt(i),counter.get(t.charAt(i))-1);
    //             }else {
    //                 counter.remove(t.charAt(i));
    //             }
    //         } else {
    //             return false;
    //         }
    //     }
    //     return counter.isEmpty();
    // }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //s.char[i]的个数加1 t.char[i]的个数减1, 最后遍历counter的值是否都为0即可
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count: counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}