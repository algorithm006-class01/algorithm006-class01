//Java：解码方法
public class P91DecodeWays {
    
    public static void main(String[] args) {
        Solution solution = new P91DecodeWays().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        public int numDecodings(String s) {
            if (s.length() == 0 || s.charAt(0) == '0') {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            int x = 1, y = 1, z = 0;
            
            for (int i = 1; i < s.length(); i++) {
                char c1 = s.charAt(i - 1), c2 = s.charAt(i);
                if (c2 == '0') {
                    if (c1 == '1' || c1 == '2') {
                        z = x;
                    } else {
                        return 0;
                    }
                }else if (c1 == '1' || (c1 == '2' && c2 <= '6')) {
                    z = x + y;
                }else{
                    z = y;
                }
                x = y;
                y = z;
            }
            
            return z;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
