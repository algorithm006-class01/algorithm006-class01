package G20200343030379;

import java.util.List;

/**
 * 367. 有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如? sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 参考优秀题解：
 */
public class LeetCode_367_379 {
    public static void main(String[] args) {
    }

    /**
     * 二分查找法
     *
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36.3 MB , 在所有 Java 提交中击败了 5.01% 的用户
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        //为了简化不必要的查询，right=num/2;
        long left=2,right=num/2;
        long mid=0;
        while (left<=right){
            mid=(left+right)/2;

            if(mid*mid==num){
                return true;
            }else if(mid*mid>num){
                right=mid-1;
            }else{
                left=mid+1;
            }

        }
        return right*right==num;
        //return false 也是没有问题的
        //return false;
    }


    /**
     * 牛顿迭代法
     *
     *  执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *  内存消耗 : 36.1 MB , 在所有 Java 提交中击败了 5.01% 的用户z
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        if(num==1)return true;

        long x=num;
        while (x*x>num){
            x=(x + num / x) / 2;
        }
        return x*x==num;
    }


}
