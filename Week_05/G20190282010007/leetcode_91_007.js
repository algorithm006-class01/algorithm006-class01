// 题目: 解码方法
/**
 * 题目描述：
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

 */

 // 解题语言: javaScript

 // 解题

/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    if(s[0] == "0") return 0;
    let dp = [1, 1], len = s.length;
    for(let i=1; i < len; ++i) {
        if(s[i - 1] != "0") {
            let num = (s[i - 1] + s[i] | 0);
            if(num >= 1 && num <= 26) {
                dp[i + 1] = s[i] != "0"? dp[i - 1] + dp[i]: dp[i - 1];
            } else if(s[i] != "0") {
                dp[i + 1] = dp[i];
            } else {
                return 0;
            }
        } else if(s[i] != "0") {
            dp[i + 1] = dp[i];
        } else {
            return 0;
        }
    }
    return dp[len];
}