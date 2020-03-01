// 字母异位词分组

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //方法一：排序 执行时间11ms 内存消耗45.1MB，
        //时间复杂度 O(NKlogK) N 是strs数组长度 K是str中字符串的最大长度，空间复杂度O(NK)
        //先判断原数组是否为null
        if (strs.length == 0){
            return new ArrayList<>();
        }

        Map<String, List> result = new HashMap<>();//创建要输出对象的实例
        for (String s : strs){
            //转换成char并进行排序
            char[] ca = s.toCharArray();
            Arrays.sort(ca);

            // 将排序后的char再转回string类型
            String key = String.valueOf(ca);

            if (!result.containsKey(key)){
                result.put(key,new ArrayList());
            }

            result.get(key).add(s);

        }

        return new ArrayList(result.values());

    }
}