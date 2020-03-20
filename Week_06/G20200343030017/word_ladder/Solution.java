package week6.word_ladder;

import java.util.*;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> bqueue = new LinkedList<>();
        Queue<String> equeue = new LinkedList<>();
        HashSet<String> bvisit = new HashSet<>();
        bvisit.add(beginWord);
        HashSet<String> evisit = new HashSet<>();
        evisit.add(endWord);
        String target;
        int count = 0;
        bqueue.add(beginWord);
        equeue.add(endWord);
        while (!bqueue.isEmpty()&&!equeue.isEmpty()){
            int bsize = bqueue.size();
            int esize = equeue.size();
            count++;
            if (bsize<=esize){
                for (int n=0;n<bsize;n++){
                    target = bqueue.poll();
                    for (String word:wordList){
                        if (!bvisit.contains(word) && !word.equals(target) &&vaild(target,word) ){
                            bvisit.add(word);
                            if (equeue.contains(word)){
                                return count+1;
                            }else{
                                bqueue.add(word);
                            }
                        }
                    }
                }
            }else{
                for (int n=0;n<esize;n++){
                    target = equeue.poll();
                    for (String word:wordList){
                        if (!evisit.contains(word) && !word.equals(target) &&vaild(target,word)){
                            evisit.add(word);
                            if (bqueue.contains(word)){
                                return count+1;
                            }else{
                                equeue.add(word);
                            }
                        }
                    }
                }
            }

            //System.out.println("begin:"+Arrays.toString(bvisit.toArray()));
            //System.out.println("end:"+Arrays.toString(evisit.toArray()));
        }
        return 0;
    }

    public boolean vaild(String target,String compare){
        int a = 0;
        for (int n=0;n<target.length();n++){
            if (target.charAt(n)==compare.charAt(n)){
                a++;
            }
        }
        if (a>=target.length()-1){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String[] words = {"lest","leet","lose","code","lode","robe","lost"};
        String beginword = "leet";
        String endword = "code";
        /*String[] words = {"miss","dusk","kiss","musk","tusk","diss","disk","sang","ties","muss"};
        String beginword = "kiss";
        String endword = "tusk";*/
        /*String[] words = {"a","b","c"};
        String beginword = "a";
        String endword = "c";*/
        List<String> wordList = Arrays.asList(words);
        Solution s = new Solution();
        System.out.println(s.ladderLength(beginword,endword,wordList));
    }
}
