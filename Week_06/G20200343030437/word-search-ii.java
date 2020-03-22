class Solution {
        Trie trie;
        int len;
        int col;
        List<String> resultList = new LinkedList<>();
        public List<String> findWords(char[][] board, String[] words) {
            trie = new Trie();
            for (String word: words) {
                trie.insert(word);
            }
            len = board.length;
            col = board[0].length;
            boolean[][] visited = new boolean[len][col];
            TrieNode root = trie.root;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < col; j++) {
                    // 判断周边是否满足条件 -- dfs
                    _DFS(board, i, j, root, visited);
                }
            }
            return resultList;
        }

        public void _DFS(char[][] board, int i, int j, TrieNode root, boolean[][] visited) {
            if (i < 0 || i >= len || j < 0 || j >= col || visited[i][j]) return;
            visited[i][j] = true;
            char ch = board[i][j];
            if (root.containsKey(ch)){
                TrieNode node = root.get(ch);
                if (node.isEnd) {
                    resultList.add(node.word);
                    node.isEnd = false;
                }

                _DFS(board, i-1, j, node,visited);
                _DFS(board, i+1, j, node,visited);
                _DFS(board, i, j-1, node,visited);
                _DFS(board, i, j+1, node,visited);
            }
            visited[i][j] = false;
        }


        class Trie {

            private TrieNode root;

            /**
             * Initialize your data structure here.
             */
            public Trie() {
                root = new TrieNode();
            }

            /**
             * Inserts a word into the trie.
             */
            public void insert(String word) {
                TrieNode trieNode = root;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (!trieNode.containsKey(ch)) {
                        trieNode.childs.add(new TrieNode(ch));
                    }
                    trieNode = trieNode.get(ch);
                }
                trieNode.isEnd = true;
                trieNode.word = word;
            }
        }
        
        class TrieNode {
            Boolean isEnd = false;
            List<TrieNode> childs = new ArrayList<>();
            char value;
            String word;

            public TrieNode(){}
            public TrieNode(char ch) {
                value = ch;
            }

            public Boolean containsKey(char ch) {
                for (TrieNode node : childs) {
                    if (node.value == ch) return true;
                }
                return false;
            }

            public TrieNode get(char ch) {
                for (TrieNode node : childs) {
                    if (node.value == ch) return node;
                }
                return null;
            }
        }
    }
