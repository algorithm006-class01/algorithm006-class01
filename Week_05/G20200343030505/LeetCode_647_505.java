/**
 * 使用栈
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:53:59
 */
class LeetCode_647_505 {
         int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j=0;j<s.length();++j) {
            for (int i=0;i<=j;++i) {
                //如果 i和j相等，要么i和j相等或者挨着 那么一定是回文串；要么i+1和j-1是回文串，i,j也是回文串
                if (s.charAt(i) == s.charAt(j) && (j-i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    ++result;
                }
           }
        }
        return result;
    }
}