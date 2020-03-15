package G20200343030015.week_05;

/**
 * Created by majiancheng on 2020/3/15.
 *
 * 91. 解码方法
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 */
public class LeetCode_91_015 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();

        int help = 1;
        int res = 0;
        if (s.charAt(len - 1) != '0') {
            res = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                help = res;
                res = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                res += help;
                //help用来存储res以前的值
                help = res-help;
            } else {
                help = res;
            }

        }
        return res;
    }
}
