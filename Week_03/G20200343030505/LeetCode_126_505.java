class LeetCode_126_505 {
    private Map<String, Set<String>> map;      // 存储构建好的无向图
    private Map<Integer, Set<String>> nxtMap;  // 记录每个搜索层次上的candidate节点
    private List<List<String>> ans;            // 存储答案
    private int minDist;                       // 转化序列的最短长度
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        this.map = new HashMap<>();
        this.nxtMap = new HashMap<>();
        this.ans = new ArrayList<>();
        int n = wordList.size();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                String a = wordList.get(i), b = wordList.get(j);
                if (check(a, b)) {
                    map.putIfAbsent(a, new HashSet<>());
                    map.putIfAbsent(b, new HashSet<>());
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }

        minDist = BFS(beginWord, endWord);
        // 如果minDist为-1，说明不存在这样的转化序列，直接返回空集
        if (minDist == -1) return ans;
        DFS(beginWord, endWord, new HashSet<String>(), new ArrayList<String>());
        return ans;
        
    }

    private void DFS(String cur, String end, Set<String> visit, List<String> path) {
        visit.add(cur);
        path.add(cur);
        if (path.size() == minDist) {
            if (cur.compareTo(end)==0) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            for (String nxt : map.get(cur)) {
                // 优化： 取当前未访问过，且在该层次候选集合中的节点
                if (visit.contains(nxt) || !nxtMap.get(path.size()).contains(nxt)) continue;
                DFS(nxt, end, visit, path);
            }
        }
        visit.remove(cur);
        path.remove(path.size()-1);
       
    }

    private int BFS(String beginWord, String endWord) {
        int level = 0;
        Set<String> visit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visit.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            nxtMap.put(level+1, new HashSet<>());
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.compareTo(endWord)==0) return level+1;
                for (String nxt : map.getOrDefault(cur, new HashSet<>())) {
                    if (visit.contains(nxt)) continue;
                    visit.add(nxt);
                    queue.offer(nxt);
                    nxtMap.get(level+1).add(nxt);
                }
            }
            level++;
        }
        return -1;
    }

    // 判断字符串a能否通过只改变一个字母转化为b
    private boolean check(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        return cnt == 1;
    }
}