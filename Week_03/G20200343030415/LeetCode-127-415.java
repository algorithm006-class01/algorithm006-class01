class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            ++count;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (String s : wordList){
                    if(!canCovert(start,s)){
                        continue;
                    }
                    if(visited.contains(s)){
                        continue;
                    }
                    if(s.equals(endWord)){
                        return count + 1;
                    }
                    visited.add(s);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public boolean canCovert(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                ++count;
                if(count > 1){
                    return false;
                }
            }
        }
        return count == 1;
    }
}