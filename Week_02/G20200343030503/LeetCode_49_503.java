
/**
 * 1. 方式一、借助hash表,将字符数组中的元素排序之后当作key入map,值为未排序的元素的集合
 *    time complexity O(nklogk)  n表示的是Strs字符串数组的所有元素,每个元素的排序klogk   
 *    space complexity O(nk)   O(NK)，排序存储在 ls 中的全部信息内容。  
 *
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> map = new HashMap<String,List<String>>();

        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String charStr = String.valueOf(chars);
            if (map.containsKey(charStr)) {
                map.get(charStr).add(str);
            }else {
                List<String> ls = new ArrayList<>();
                ls.add(str);
                map.put(charStr,ls);
            }
        }

        return new ArrayList<>(map.values());
    }
}