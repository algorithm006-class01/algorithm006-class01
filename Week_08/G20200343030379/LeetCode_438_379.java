package G20200343030379;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 解题方法：
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/javayou-hua-labuladongda-lao-hua-dong-chuang-kou-t/
 *
 * 参考优秀题解：
 */
public class LeetCode_438_379 {

    public static void main(String[] args) {
    }


    /**
     * 执行用时 : 32 ms , 在所有 Java 提交中击败了 45.14% 的用户
     * 内存消耗 : 41.3 MB , 在所有 Java 提交中击败了 5.88% 的用户
     *
     * 题解：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
     * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/javayou-hua-labuladongda-lao-hua-dong-chuang-kou-t/
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        Queue<Integer> res=new LinkedList<>();
        int left=0,right=0;
        Map<Character,Integer> window=new HashMap<>();
        Map<Character,Integer> need=new HashMap<>();

        //初始化异位词
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);
        }

        int match=0;
        while (right<s.length()){
            //检查是否与异位词匹配
            char c = s.charAt(right);
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);

                //出现次数相同，匹配+1
                if(need.get(c).equals(window.get(c))){
                    match++;
                }
            }

            right++;

            //满足异位词
            while (match==need.size()){
                if((right-left)==p.length()){
                    res.add(left);
                }

                char c1 = s.charAt(left);
                if(need.containsKey(c1)){
                    //移除左边的值
                    window.put(c1,window.get(c1)-1);
                    if(window.get(c1)<need.get(c1)){
                        match--;
                    }
                }
                left++;
            }

        }
        return new ArrayList<>(res);
    }

    /**
     * 数组法题解：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/javayou-hua-labuladongda-lao-hua-dong-chuang-kou-t/
     *
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 91.64% 的用户
     * 内存消耗 : 40.8 MB , 在所有 Java 提交中击败了 5.88% 的用户
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int[] windows =new int[26];
        int[] needs = new int[26];
        List<Integer> res=new ArrayList<>();

        for (char c : p.toCharArray()) {
            int ci=c - 'a';
            needs[ci]++;
        }

        int left=0,right=0,total=p.length();
        while (right < s.length()){
            int cr = s.charAt(right) - 'a';
            //匹配中
            if(needs[cr]>0){
                windows[cr]++;
                if(windows[cr]<=needs[cr]){
                    total--;
                }
                //System.out.println(Arrays.toString(windows)+"=="+total+"right");
            }


            while (total==0){
                if(right - left + 1  == p.length()){
                    res.add(left);
                }
                int cl = s.charAt(left) - 'a';
                if(needs[cl]>0){
                    windows[cl] --;
                    if(windows[cl] < needs[cl]){
                        total++;
                    }
                    //System.out.println(Arrays.toString(windows)+"=="+total+"left");

                }
                left++;
            }
            right ++;
        }

        return res;
    }


    /**
     * 默写版，变量名优化
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 91.64% 的用户
     * 内存消耗 : 40.8 MB , 在所有 Java 提交中击败了 5.88% 的用户
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams3(String s, String p) {
        int[] windows=new int[26];
        int[] needs=new int[26];
        List<Integer> res=new ArrayList<>();
        int left=0,right=0,total=p.length();
        for (int i = 0; i < p.length(); i++) {
            int c=p.charAt(i)-'a';
            needs[c]++;
        }


        while (right<s.length()){
            int cr=s.charAt(right)-'a';
            if(needs[cr]>0){
                windows[cr]++;
                if(windows[cr]<=needs[cr]){
                    total--;
                }

            }


            while (total == 0){
                if(right-left+1 == p.length()){
                    res.add(left);
                }
                int cl = s.charAt(left)-'a';
                if(needs[cl]>0){
                    windows[cl]--;
                    if(windows[cl]<needs[cl]){
                        total++;
                    }
                }

                left++;
            }

            right++;
        }

        return res;

    }

}