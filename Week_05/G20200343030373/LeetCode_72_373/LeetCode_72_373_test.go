//https://leetcode-cn.com/problems/edit-distance/
package edit_distance_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestStringMatch(t *testing.T) {
	assert.Equal(t, 3, minDistance("horse", "ros"))
	assert.Equal(t, 5, minDistance("intention", "execution"))
}

func minDistance(word1 string, word2 string) int {
	//状态定义：dp[i][j]，word1的前i个字符 与 word2的前j个字符 相同 所需的最少操作数
	//最终结果：m是word1的长度，则最终结果要放在dp[m][n]中 - 则数组长度为m+1
	m, n := len(word1), len(word2)
	dp := make([][]int, m+1) //初始化二维数组，否则会出现`未将对象引用到对象的实例`
	for i := range dp {
		dp[i] = make([]int, n+1)
	}

	//初始值
	//word1的i个字符转化成word2的0个字符，只能word1删除i次
	//word1的0个字符转化成word2的j个字符，只能word1插入j次
	for i := 0; i <= m; i++ {
		dp[i][0] = i
	}
	for j := 0; j <= n; j++ {
		dp[0][j] = j
	}

	//状态方程
	//删除操作 从而相等 所以先让前i-1个字符变为j字符，然后在第i处删除 即dp[i-1][j]+1
	//插入操作 从而相等 所以先让前i个字符变为j-1字符，然后在第i处插入j代表的字符 即dp[i][j-1]+1
	//替换操作 从而相等 if(i处等于j处 不需要替换) 即dp[i-1][j-1], else 需要替换 dp[i-1][j-1]+1
	//上述取个最小值即可
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1]) //删除、插入时

			temp := 0
			if word1[i-1] == word2[j-1] {
				temp = 0
			} else {
				temp = 1
			}
			dp[i][j] = min(dp[i][j], dp[i-1][j-1]+temp) //替换时
		}
	}
	return dp[m][n]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
