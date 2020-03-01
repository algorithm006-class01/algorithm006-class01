
/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */
// 利用level order traversal的思路，不同的是到最后一层直接返回该层。
// 可以利用LinkedList是Queue和List的子类的特性，当成Queue处理，完后可以直接当List返回
// @lc code=start
class Solution_1 {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> current = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> initResult = new ArrayList<>();
            initResult.add(i);
            current.offer(initResult);
        }
        return bfs(n, k, current, 1);
    }

    private List<List<Integer>> bfs(int n, int k, LinkedList<List<Integer>> currentQueue, int depth) {
        if (depth == k) {
            return currentQueue;
        }

        int currentSize = currentQueue.size();
        for (int i = 0; i < currentSize; i++) {
            List<Integer> temp = currentQueue.poll();
            for (int j = temp.get(temp.size() - 1) + 1; j <= n; j++) {
                List<Integer> currentList = new ArrayList<>(temp);
                currentList.add(j);
                currentQueue.offer(currentList);
            }
        }
        return bfs(n, k, currentQueue, depth + 1);
    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        recurser(n, k, results, result, 1);
        return results;
    }

    private void recurser(int n, int k, List<List<Integer>> results, List<Integer> currentResult, int startNum) {
        if (currentResult.size() == k) {
            results.add(currentResult);
            return;
        }

        for (int i = startNum; i <= n; i++) {
            currentResult.add(i);
            recurser(n, k, results, new ArrayList<>(currentResult), i + 1);
            currentResult.remove(currentResult.size() - 1);
        }
    }
}
// @lc code=end
