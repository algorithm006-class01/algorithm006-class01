class Solution {

    /**
     * 暴力法 也是最容易能想到的
     * 思路解析：
     * 1、遍历 并对每个字符串数组中的 字符串转为字符后 排序
     * 2、将排序后的 字符数组 变为 字符串后 作为 map中的key（如果是异位词key一样，代表用key来分组）
     * 3、如果key 在map中已经存在 则加入到map key对应的 list中
     * 4、如果key 在map中不存在  则创建该key对应的list
     *
     * 时间复杂度分析：
     * O（n(klogk)） 遍历strs为 O（N）
     * 字符排序为快排 平均时间复杂度为O（klogk）
     * 合起来就是 O（NKlogK）
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     *
     * 首先初始化 key = "0#0#0#0#0#"，数字分别代表 abcde 出现的次数，# 用来分割。
     * 这样的话，"abb" 就映射到了 "1#2#0#0#0"。
     * "cdc" 就映射到了 "0#0#2#1#0"。
     * "dcc" 就映射到了 "0#0#2#1#0"。
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 时间复杂度分析：
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] num = new int[26];
            //记录每个字符的次数
            for (int j = 0; j < strs[i].length(); j++) {
                num[strs[i].charAt(j) - 'a']++;
            }
            // 转成 0#2#2# 类似的形式
            // 相当于代替排序的解法
            String key = "";
            for (int j = 0; j < num.length; j++) {
                key = key + num[j] + '#';
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());
    }




}