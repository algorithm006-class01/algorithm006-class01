package G20200343030379;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 * ?
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 方法1：暴力法
 * 方法2：哈希法
 * 方法3：数组哈希法
 * 参考优秀题解：官方题解
 */
public class LeetCode_387_379 {

    public static void main(String[] args) {
        //十进制转二进制
        //String s = Integer.toBinaryString(-2147483648);
        new LeetCode_387_379().firstUniqChar2("leetcode");

    }

    /***
     * 执行用时 : 35 ms , 在所有 Java 提交中击败了 47.67% 的用户
     * 内存消耗 : 39.8 MB , 在所有 Java 提交中击败了 5.05% 的用户
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c)==1){
                return i;
            }
        }
        return -1;

       /* //要求是输出索引，不是输出值
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getValue());
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;*/

    }

    /**
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 87.65% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 5.05% 的用户
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        int[] nums=new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            nums[c-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(nums[c-'a']==1){
                return i;
            }
        }
        return -1;

    }
}