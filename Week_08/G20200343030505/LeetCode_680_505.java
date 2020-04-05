//既然可以删除一个元素  那么判断时 如果遇到 i和j元素不相等   判断i,j-1
//以及i+1,j是否是回文；只要有一个是回文就是
// 如abbaa   bba中b!=a  但是bb是回文
class LeetCode_387_505 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            //如果当前不相等那么判断 两个子串是否是回文
            //如果 left+1,right 是回文 或者left,right-1是回文 那么就是回文 需要至少满足一个即可
            if (s.charAt(left) != s.charAt(right)){
                return isPalindrome(   s.substring(left+1, right+1)   ) || isPalindrome(  s.substring(left, right)  );
            }
            ++left;
            --right;
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            --j;
            ++i;
        }

        return true;
    }


}