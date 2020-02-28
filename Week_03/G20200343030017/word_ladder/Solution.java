package week3.word_ladder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        //HashSet<String> set = new HashSet<>();
        boolean[] set = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx!=-1){
            set[idx] = true;
        }
        List<String> tempList = new ArrayList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int g =0;g<size;g++){
                String inputWord = queue.poll();
                for (int u=0;u<wordList.size();u++) {
                    String temp =wordList.get(u);
                    if (temp.equals(inputWord)) {
                        continue;
                    }
                    if (set[u]) {
                        continue;
                    }
                    int k = 0;
                    for (int n = 0; n < temp.length(); n++) {
                        if (temp.charAt(n)==inputWord.charAt(n)) {
                            k++;
                        }
                        if (k == temp.length() - 1) {
                            if (temp.equals(endWord)){
                                return level+1;
                            }
                            set[u]=true;
                            if (!queue.contains(temp)){
                                tempList.add(temp);
                            }
                        }
                    }
                }
            }
            for (String aaa:tempList){
                if (!queue.contains(aaa)){
                    queue.add(aaa);
                }
            }
            tempList.clear();
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] aaa = {"hot","dot","dog","lot","log","cog"};
        //String beginWord = "a";
        //String endWord = "c";
        //String[] aaa = {"a","b","c"};
        List<String> wordList = Arrays.asList(aaa) ;
        Solution s = new Solution();
        System.out.println(s.ladderLength(beginWord,endWord,wordList));
    }
}
