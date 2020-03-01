//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //其中每个键 K 是一个排序字符串，每个值是初始输入的字符串列表
        // 查看长度都是 .length
        if (strs.length == 0) return new ArrayList();
        // 创建一个 key 是 String,value 是 List 的 hashmap
        Map<String,List> ans = new HashMap<String, List>();
        for (String s: strs) {
            // string 没有 sort 函数 转换成 array
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            // 再转换回 string calueOf 把分散的字符拼接成 string
            String key = String.valueOf(ca);
            // hashmap cintainsKey 方法：判断key是否在hashmap的key中
            if (!ans.containsKey(key)) {
                // 如果不在 把key当做hashmap 的key hashmap.put
                ans.put(key, new ArrayList());
            }
            // 如果已经包含了
            // hashmap.get(key).add() array.add
            ans.get(key).add(s);
        }
        // hashmap.values();
        return new ArrayList(ans.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
