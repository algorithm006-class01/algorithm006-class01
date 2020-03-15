/**
 * 使用栈
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:53:59
 */
class LeetCode_32_505 {
        if (s == null || s.length() < 2) {
            return 0;
        }

        //dpi 以i结尾的最长括号长度
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i=1;i<s.length();++i) {
            if (s.charAt(i) != '(') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = i>1?dp[i-2] + 2:2;
                //如 (())  也就是i是),然后dp[i-1]之前的一个是(,那么就可以拼然后再加上之前的有效长度
                } else  if (i>=dp[i-1]+1 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = 2 + dp[i-1] + (i-dp[i-1] >= 2?dp[i-dp[i-1]-2]:0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}