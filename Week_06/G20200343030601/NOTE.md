# 学习笔记（第五周）

**学号：** G20200343030601

**姓名：** 冯学智

**微信：** SDMrFeng

## 本周学习总结

###  212. 单词搜索 II 用 Trie 树方式实现的时间复杂度

1. 尝试从board的每个位置作为初始位置查找，查找次数为O(M*N)，M和N分别是Board的长和高；
2. 每次查找是DFS的递归实现，向四个方向分别探索，探索深度和Trie树的层次一致，记Trie树的平均层数（也就是words中单词的平均长度）为W，则每次查找的时间复杂度为O(4^W)
* 综上：单词搜索 II 用 Trie 树方式实现的时间复杂度为O(M*N*4^W)

### DP解决括号配对问题
```Java
class Solution {
    // 动态规划解决方案
    // dp[i] = "(" + dp[j] + ")" + dp[i - j - 1], j = 0, 1, ..., i - 1
    // 时间复杂度：暂时不会分析
    // 空间复杂度：
    public List<String> generateParenthesis(int n) {
        if (0 == n) return new ArrayList<String>();

        List<List<String>> dp = new ArrayList<>(n+1);
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            List<String> curStrList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> strList1 = dp.get(j);
                List<String> strList2 = dp.get(i - j - 1);
                for (String str1 : strList1) {
                    for (String str2 : strList2) { 
                        curStrList.add("(" + str1 + ")" + str2);
                    }
                }
            }
            dp.add(curStrList);
        }

        return dp.get(n);
    }
}
```


### 总结双向BFS的代码模板
```Python
def BFS(graph, start, end): 
    front = {start}
    back = {end} 
    visited = set()
    visited.add(start) 

    while front and back: 
        temp_front = {}
        for node in front: 
            visited.add(node) 
 
            process(node) 
            nodes = generate_related_nodes(node) 
            temp_front.add(nodes)

        front = temp_front
        if len(back) < len(front):
            front, back = back, front
    # other processing work 
	...
```