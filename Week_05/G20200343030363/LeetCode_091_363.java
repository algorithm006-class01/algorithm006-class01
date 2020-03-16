package cn.geek.week5;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月15日 11:51:00
 */
public class LeetCode_091_363 {
    
    /**
     * Num decodings int.
     *
     * @param s
     *            the s
     * @return the int
     */
    public int numDecodings(String s) {
        int len = s.length();
        int end = 1;
        int cur = 0;
        if (s.charAt(len - 1) != '0') {
            cur = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                // end 前移
                end = cur;
                cur = 0;
                continue;
            }
            int ans1 = cur;
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = end;
            }
            // end 前移
            end = cur;
            cur = ans1 + ans2;
        }
        return cur;
    }
}
