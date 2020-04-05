/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @date Apr 5 2020
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if(strs.length == 0) return "";
//         String prefix = strs[0];
//         for (int i = 1; i < strs.length; i ++) {
//             while (strs[i].indexOf(prefix) != 0) {
//                 prefix = prefix.substring(0, prefix.length() - 1);
//                 if (prefix.isEmpty()) return "";
//             }
//         }
//         return prefix;
//     }
// }

// @date Apr 5 2020
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs.length == 0) return "";
//         for (int i = 0; i < strs[0].length(); i ++) {
//             char c = strs[0].charAt(i);
//             for (int j = 1; j < strs.length; j ++) 
//                 if (i == strs[j].length() || strs[j].charAt(i) != c)
//                     return strs[0].substring(0, i);
//         }
//         return strs[0];
//     }
// }

// @date Apr 5 2020
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs.length == 0) return "";
//         return dfs(strs, 0, strs.length - 1);
//     }
//     String dfs(String[] strs, int l, int r) {
//         if (l == r)
//             return strs[l];
//         int m = l + (r - l) / 2;
//         String left = dfs(strs, l, m);
//         String right = dfs(strs, m + 1, r);
//         int len = Math.min(left.length(), right.length());
//         for (int i = 0; i < len; i ++) 
//             if (left.charAt(i) != right.charAt(i)) 
//                 return left.substring(0, i);
//         return left.substring(0, len);
//     }
// }

// @date Apr 5 2020
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs.length == 0) return "";
//         int low = 1, high = Integer.MAX_VALUE;
//         for (String str: strs)
//             high = Math.min(high, str.length());
//         while (low <= high) {
//             // TODO
//             // int mid = low + (high - low) / 2; // low=2,high=3, mid=3
//             int mid = (low + high) / 2; // low=2,high=3, mid=2
//             if (isCommonPrefix(strs, mid)) 
//                 low = mid + 1;
//             else
//                 high = mid - 1;
//         }
//         // return strs[0].substring(0, low - (high - low) / 2); // low=2,high=3, mid=3
//         return strs[0].substring(0, (low + high) / 2); // low=2,high=3, mid=2
        
//     }
//     boolean isCommonPrefix(String[] strs, int len) {
//         String cp = strs[0].substring(0, len);
//         for (int i = 1; i < strs.length; i ++) 
//             if (!strs[i].startsWith(cp))
//                 return false;
//         return true;
//     }
// }

// @lc code=start
// @date Apr 5 2020
// @solution trie
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) 
            trie.insert(str);
        
        TrieNode current = trie.root;
        String result = "";
        while (current.isEnd != true) {
            int count = 0;
            int index = 0;
            for (int i = 0; i < 26; i++) {
                if (current.childs[i] != null) {
                    count += 1;
                    index = i;
                }
            }
            if (count != 1) return result;
            current = current.childs[index];
            result += String.valueOf(current.value);
        }
        return result;
        
    }
    
    class TrieNode {
        static final int numAlpha = 26;
        char value;
        int count;
        TrieNode[] childs;
        boolean isEnd;
        public TrieNode(char c) {
            value = c;
            count = 0;
            childs = new TrieNode[numAlpha];
            isEnd = false;
        }
    }
    
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode(' ');
        }
        
        public void insert(String word) {
            if (this.search(word) == true) return;
            
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    c = (char)(c + 'a' - 'A');
                }
                if (current.childs[c - 'a'] != null) {
                    current = current.childs[c - 'a'];
                }
                else {
                    current.childs[c - 'a'] = new TrieNode(c);
                    current = current.childs[c - 'a'];
                }
                current.count++;
            }
            current.isEnd = true;
        }
        
        public boolean search(String word) {
            TrieNode current = root;
            
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = 0;
                if (c >= 'A' && c <= 'Z') {
                    index = c - 'A';
                }
                else {
                    index = c - 'a';
                }
                if (current.childs[index] == null) {
                    return false;
                }
                else {
                    current = current.childs[index];
                }
            }
            if (current.isEnd == true) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
// @lc code=end

