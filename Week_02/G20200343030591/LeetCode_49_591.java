class Solution {

    /**
     * 暴力法 也是最容易能想到的
     * 思路解析：
     * 1、遍历 并对每个字符串数组中的 字符串转为字符后 排序
     * 2、将排序后的 字符数组 变为 字符串后 作为 map中的key（如果是异位词key一样，代表用key来分组）
     * 3、如果key 在map中已经存在 则加入到map key对应的 list中
     * 4、如果key 在map中不存在  则创建该key对应的list
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

}