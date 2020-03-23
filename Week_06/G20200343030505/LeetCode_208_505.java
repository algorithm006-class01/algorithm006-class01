/**
* 定义trie树的节点 每个节点存储了指向下一个节点的links数组 当前节点isEnd标记是否是尾节点
*/
class TrieNode {
    private final int R= 26;
    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] == null ?false:true;
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;//定义根节点
   
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
   /**
     * 从root开始判断 如果links没有就创建，然后下一层判断;
     * 注意实际节点总数=word.length + 1;因为多了一个root节点
     * @param word
     */
    public void insert(String word) {
        TrieNode node = this.root;
        for (int i=0;i<word.length();++i) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            } 
            node = node.get(ch);
        }

        node.setEnd();
    }


  
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           //从root开始查找 此处node不可能为null
           if (node.containsKey(curLetter)) {
               node = node.get(curLetter);
           } else {
               return null;
           }
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }


    
     public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }


}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */