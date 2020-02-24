class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> rules = new HashMap();
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        for (String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortStr = new String(arr);
            if (!rules.containsKey(sortStr)) {
                rules.put(sortStr, new ArrayList());
            }
            rules.get(sortStr).add(s);
        }
        return new ArrayList(rules.values());
    }
}