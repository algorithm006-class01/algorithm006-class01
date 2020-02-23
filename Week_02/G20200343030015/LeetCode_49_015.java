package G20200343030015.week_02;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * Created by majiancheng on 2020/2/23.
 */
public class LeetCode_49_015 {

    //1.暴力破解，求出每个元素的唯一key，然后通过map操作
    //2.通过sort字符串数据，生成字符串key信息
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        Map<String, List<String>> result = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if (result.get(key) == null) {
                result.put(key, new ArrayList<String>());
            }
            result.get(key).add(strs[i]);
        }

        return new ArrayList<List<String>>(result.values());
    }
}
