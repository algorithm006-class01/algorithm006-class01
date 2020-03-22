class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLength = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < wordLength; i++) {
                String express = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
                List<String> combos = allComboDict.getOrDefault(express, new ArrayList<>());
                combos.add(word);
                allComboDict.put(express, combos);
            }
        });
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 0));

        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int level = pair.getValue();
            if (word.equalsIgnoreCase(endWord)) {
                return level + 1;
            }
            for (int i = 0; i < wordLength; i++) {
                String express = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
                for(String potential : allComboDict.getOrDefault(express, new ArrayList<>())) {
                    if (!visited.containsKey(potential)) {
                        queue.add(new Pair<>(potential, level + 1));
                        visited.put(potential, true);
                    }

                }
            }
        }
        return 0;
    }
}