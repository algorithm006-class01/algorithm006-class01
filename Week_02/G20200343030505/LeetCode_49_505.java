class Solution_49_505 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        if (strs == null || strs.length == 0)   {
            return result;
        }

        Map<String, List<String>> map = new HashMap();
        for (String str:strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String t = String.valueOf(arr);
            if (map.containsKey(t)) {
                map.get(t).add(str);
            } else {
                List<String> tList = new ArrayList<String>();
                tList.add(str);
                map.put(t, tList);
            }
        }

       return new ArrayList(map.values());
    }
}