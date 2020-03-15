/**
 * 使用栈
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:53:59
 */
class LeetCode_91_505 {
         if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        //本题是动态规划转移方程
        //
        //如果s[i]=0,那么只有10和20满足 即d[i]=dp[i-1]
        //如果s[i-1]=1,那么dpi=dpi-1+dpi-2;
        //如果s[i-1]=2,并且s[i]<7 dpi=dpi-1+dpi-2；否则dpi=dpi-1
        //其余情况 dpi=dpi-1;
        int last1 = 1;
        int last2 = 1;
        for (int i=1;i<s.length();++i) {
            int tmp = last1;
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    last1 = last2;
                } else {
                    return 0;
                } 
            } else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) < '7')) {
                last1 = last1 + last2;
            }
            last2 = tmp;
        }       

        return last1;
    }
}