import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
//    1.排序数组分类
    public List<List<String>> groupAnagrams(String[] strs) {
//        1.判断字符串长度是否为 0
        if (strs.length == 0) {
//            为零返回初始化数组
            return new ArrayList<>();
        }
//        2.初始化hashMap  string，lsit
        HashMap<String, List> ans = new HashMap<>();
//        3.循环 字符串数组
        for (String s : strs) {
//            4.原始字符串转数组
            char[] chars = s.toCharArray();
//            5.数组排序，为了得到异位词统一的字符串
            Arrays.sort(chars);
//            6.排序数组转为字符串
            String key = String.valueOf(chars);
//            7.判断 哈希表中是否存在排序后的字符串
            if (!ans.containsKey(key)) {
//                不存在表示：这个字符是新的异位词，key：排序后字符串，value：初始化数组list
                ans.put(key, new ArrayList());
            }
//           8.存在该统一字符串，将原始字符串放入value中的list中
//            List list = ans.get(key);
//            list.add(s);
            ans.get(key).add(s);
        }
//        9.返回结果 values()将map值结果转换为数组
        return new ArrayList(ans.values());
    }

//    2.计数分类
    public List<List<String>> groupAnagrams(String[] strs) {
//        判断长度
        if (strs.length == 0){
            return new ArrayList<>();
        }
//        初始化hashmap string，lsit
        HashMap<String, List> map = new HashMap<>();
        int[] count = new int[26];
//        循环字符串数组
        for (String s :strs) {
//            将计数器所有位置填充为 0
            Arrays.fill(count, 0);
//            遍历字符串
            for (char c : s.toCharArray()) {
//                计数器对每个字母出现的频率计数 ++
                count[c - 'a']++;
            }
//            初始化拼接字符串
            StringBuilder sb = new StringBuilder("");
//           特殊化处理 将每个字母计数器的梳理追加在字符串后面 26个字母
            for (int i = 0;i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
//           类型转换为string
            String key = sb.toString();
//        判断排序后的字符串 key 在不在map的key中
            if (!map.containsKey(key)) {
//                不在：key：排序后的字符串，value：初始化数组list
                map.put(key, new ArrayList());
            }
//        将原始字符串放到每个map key 的list 中
            map.get(key).add(s);
        }
//        返回map转list
        return new ArrayList(map.values());
    }
}