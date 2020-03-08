package G20200343030379;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  69. x 的平方根
 *  实现?int sqrt(int x)?函数。
 *
 * 计算并返回?x?的平方根，其中?x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * ?    由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：
 */
public class LeetCode_69_379 {
    public static void main(String[] args) {
    }

    /**
     * 二分查找法
     *
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 79.94% 的用户
     * 内存消耗 : 36.9 MB , 在所有 Java 提交中击败了 5.12% 的用户
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long left=0,right=x;
        long mid=0;

        while (left<=right){
            mid=(left+right)/2;
            if(mid*mid==x){
                return (int) mid;
            }else if(mid*mid>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return  (int) right;
    }

    /**
     * 牛顿迭代法
     *
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 79.94% 的用户
     * 内存消耗 : 36.7 MB , 在所有 Java 提交中击败了 5.12% 的用户
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        long a=x;
        while (a*a>x){
            a = (a + x / a) / 2;
        }
        return (int) a;
    }


}
