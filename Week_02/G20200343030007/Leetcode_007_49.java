   public List<List<String>> groupAnagrams(String[] strings) {
        if (strings.length == 0) return new ArrayList<List<String>>();
        // key -> value, key: 排序后的字符串，value：当前字符串的所有可能组成的数组
        Map<String, List<String>> ans = new HashMap<String, List<String>>();
        for (String s : strings) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<String>());
            ans.get(key).add(s);
        }

        return new ArrayList<List<String>>(ans.values());
    }

