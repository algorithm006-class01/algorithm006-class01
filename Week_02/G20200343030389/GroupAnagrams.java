package follow.phenix.ice.algorithm.weektwo;

import java.util.*;

/**
 * @author admin
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] stringArray = new String[]{"ea_t", "t_ea", "tan__", "ate_", "__nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(stringArray));
        System.out.println(groupAnagrams.groupAnagramsBySortChar(stringArray));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<Character, Integer> charIntMap = getCharIntMap(strs);
        Map<Integer, Character> intCharMap = getIntCharMap(charIntMap);
        Map<String, List<String>> resultMap = new HashMap<>(20);
        for (String str : strs) {
            String strAfterOrder = getStringAfterOrder(charIntMap, intCharMap, str);
            if (resultMap.containsKey(strAfterOrder)) {
                List<String> stringList = resultMap.get(strAfterOrder);
                stringList.add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                resultMap.put(strAfterOrder, stringList);
            }
        }
        return new ArrayList<>(resultMap.values());
    }

    private List<List<String>> groupAnagramsBySortChar(String[] stringArray) {
        Map<String, List<String>> resultMap = new HashMap<>(20);
        for (String string : stringArray) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String stringAfterOrder = Arrays.toString(chars);
            if (resultMap.containsKey(stringAfterOrder)) {
                resultMap.get(stringAfterOrder).add(string);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(string);
                resultMap.put(stringAfterOrder, stringList);
            }
        }
        return new ArrayList<>(resultMap.values());
    }

    private Map<Character, Integer> getCharIntMap(String[] stringArray) {
        int baseNum = 1;
        Map<Character, Integer> result = new HashMap<>(100);
        for (String str : stringArray) {
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                if (result.containsKey(aChar)) {
                    continue;
                }
                result.put(aChar, baseNum++);
            }
        }
        return result;
    }

    private Map<Integer, Character> getIntCharMap(Map<Character, Integer> charIntMap) {
        Map<Integer, Character> result = new HashMap<>(100);
        charIntMap.forEach((k, v) -> result.put(v, k));
        return result;
    }

    private String getStringAfterOrder(Map<Character, Integer> charIntMap,
                                       Map<Integer, Character> intCharMap,
                                       String str) {
        char[] strCharArray = str.toCharArray();
        List<Integer> orderIntList = new ArrayList<>();
        for (char aChar : strCharArray) {
            orderIntList.add(charIntMap.get(aChar));
        }
        orderIntList.sort(Comparator.comparingInt(o -> o));
        StringBuilder orderBuilder = new StringBuilder();
        for (Integer integer : orderIntList) {
            orderBuilder.append(intCharMap.get(integer));
        }
        return orderBuilder.toString();
    }
}
