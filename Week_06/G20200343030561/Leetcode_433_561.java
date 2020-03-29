import java.util.*;
/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
// dfs
// @date Feb 26 2020
/* class Solution {
    int minStepCount = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<String>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }
    private void dfs (HashSet<String> step, int stepCount, 
        String current, String end, String[] bank) {
        if (current.intern() == end.intern()) 
            minStepCount = Math.min(stepCount, minStepCount);
        for (String str: bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) 
                if (current.charAt(i) != str.charAt(i))
                    if (++diff > 1) break;
            if (diff == 1 && !step.contains(str)) {
                step.add(str);
                dfs(step, stepCount + 1, str, end, bank);
                step.remove(str);
            }
        }
    }
}
*/
// bfs
// @date Feb 26 2020
/* class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> pool = new HashSet<>(Arrays.asList(bank));
        if (! pool.contains(end)) return -1;
        char[] nucleobases = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        pool.remove(start);
        int step = 0;
        while (!queue.isEmpty()) {
            step ++;
            for (int c = queue.size(); c > 0; c--) {
                char[] gene = queue.poll().toCharArray();
                for (int i = 0; i < gene.length; i++ ) {
                    char replaced = gene[i];
                    for (int j = 0; j < 4; j ++) {
                        gene[i] = nucleobases[j];
                        String mutation = new String(gene);
                        if (end.equals(mutation)) 
                            return step;
                        if (pool.contains(mutation)) {
                            pool.remove(mutation);
                            queue.offer(mutation);
                        }
                    }
                    gene[i] = replaced;
                }
            }
        }
        return -1;
    }
} */
// bidirectional bfs(two-end bfs)
// @date Feb 26 2020
// class Solution {
//     public int minMutation(String start, String end, String[] bank) {
//         HashSet<String> pool = new HashSet<>(Arrays.asList(bank));
//         if (!pool.contains(end)) return -1;
//         char[] nucleobases = {'A', 'C', 'G', 'T'};
//         Queue<String> pos = new LinkedList<String>();
//         Queue<String> neg = new LinkedList<String>();
//         pos.offer(start);
//         neg.offer(end);
//         int step = 0;
//         char[] gene;
//         while (!pos.isEmpty() && !neg.isEmpty()) {
//             if (pos.size() > neg.size()) {
//                 Queue<String> t = pos;
//                 pos = neg;
//                 neg = t;
//             }
//             Queue<String> queue = new LinkedList<String>();
//             for (int p = pos.size(); p > 0; p --) {
//                 gene = pos.poll().toCharArray();
//                 for (int i = 0; i < gene.length; i++ ) {
//                     char replaced = gene[i];
//                     for (int j = 0; j < 4; j ++) {
//                         gene[i] = nucleobases[j];
//                         String mutation = new String(gene);
//                         // String mutation = String.valueOf(gene);
//                         if (neg.contains(mutation)) 
//                             return step + 1;
//                         if (pool.contains(mutation)) {
//                             pool.remove(mutation);
//                             queue.offer(mutation);
//                         }
//                     }
//                     gene[i] = replaced;
//                 }
//             }
//             step ++;
//             pos = queue;
//         }
//         return -1;
//     }
// }

// @solution two-end bfs best
// todo hashset is better than linkedlist
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> dict = new HashSet<>(Arrays.asList(bank)), temp = new HashSet<>();
        Set<String> front = new HashSet<>(), back = new HashSet<>();
        if (!dict.contains(end)) return -1;
        char[] nucleobases = {'A', 'C', 'G', 'T'};
        int step = 0;
        front.add(start);
        back.add(end);
        dict.remove(start);
        while (!front.isEmpty() && !back.isEmpty()) {
            if (front.size() > back.size()) {
                temp = front;
                front = back;
                back = temp;
            }
            temp = new HashSet<>();
            for (String sequence : front) {
                for (int i = sequence.length() - 1; i >= 0; i --) {
                    char[] genes = sequence.toCharArray();
                    for (char base : nucleobases) {
                        if (genes[i] == base) continue;
                        genes[i] = base;
                        String mutation = String.valueOf(genes);
                        if (back.contains(mutation)) return step + 1;
                        if (dict.contains(mutation)) {
                            dict.remove(mutation);
                            temp.add(mutation);
                        }

                    }
                }
            }
            step ++;
            front = temp;
        }
        return -1;
    }
}
// @lc code=end

