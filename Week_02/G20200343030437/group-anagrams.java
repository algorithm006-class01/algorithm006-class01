class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;
            if (length == 0) return null;

            Map<String,List<String>> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String str = String.valueOf(chars);
                if (!map.containsKey(str)) map.put(str, new ArrayList<>());
                map.get(str).add(strs[i]);
            }
            return new ArrayList<>(map.values());

    }
}
