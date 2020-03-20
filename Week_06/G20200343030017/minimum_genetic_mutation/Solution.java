package week6.minimum_genetic_mutation;

import java.util.*;

public class Solution {

    public int minMutation(String start, String end, String[] bank) {
        Queue<String> bqueue = new LinkedList<>();
        Queue<String> equeue = new LinkedList<>();
        HashSet<String> bvisit = new HashSet<>();
        bvisit.add(start);
        HashSet<String> evisit = new HashSet<>();
        evisit.add(end);
        String target;
        int count = 0;
        bqueue.add(start);
        equeue.add(end);
        while (!bqueue.isEmpty()&&!equeue.isEmpty()){
            int bsize = bqueue.size();
            int esize = equeue.size();
            if (bsize<=esize){
                target = bqueue.poll();
                for (String word:bank){
                    if (!bvisit.contains(word) && !word.equals(target) &&vaild(target,word) ){
                        bvisit.add(word);
                        if (equeue.contains(word)){
                            return count+1;
                        }else{
                            bqueue.add(word);
                        }
                    }
                }
                count++;
            }else{
                target = equeue.poll();
                for (String word:bank){
                    if (!evisit.contains(word) && !word.equals(target) &&vaild(target,word)){
                        evisit.add(word);
                        if (bqueue.contains(word)){
                            return count+1;
                        }else{
                            equeue.add(word);
                        }
                    }
                }
                count++;
            }
        }
        return -1;
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
        String[] words = {"AACCGGTA"};
        String beginword = "AACCGGTT";
        String endword = "AACCGGTA";
        /*String[] words = {"miss","dusk","kiss","musk","tusk","diss","disk","sang","ties","muss"};
        String beginword = "kiss";
        String endword = "tusk";*/
        /*String[] words = {"a","b","c"};
        String beginword = "a";
        String endword = "c";*/
        Solution s = new Solution();
        System.out.println(s.minMutation(beginword,endword,words));
    }
}
