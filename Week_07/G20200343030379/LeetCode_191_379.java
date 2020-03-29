package G20200343030379;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 191. 位1的个数
 *
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’?的个数（也被称为汉明重量）。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011?中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000?中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * ?
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的?示例 3?中，输入表示有符号整数 -3。
 * ?
 *
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * //解法：
 *      0、暴力法，转二进制，迭代遍历
 *      1、掩码法
 *      2、&1 ， x = x >> 1 ; (32)
 *      3、while（x > 0 ） {count ++; x = x & (x - 1)}
 *
 * 参考优秀题解：
 * https://leetcode-cn.com/problems/number-of-1-bits/solution/man-hua-gan-jiu-dui-liao-ao-li-gei-by-ivan1-2/
 */
public class LeetCode_191_379 {

    public static void main(String[] args) {
        //十进制转二进制
        String s = Integer.toBinaryString(-3);
        new LeetCode_191_379().hammingWeight3(-3);
    }


    // you need to treat n as an unsigned value

    /**
     * 暴力法
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 7.84% 的用户
     * 内存消耗 : 36.3 MB , 在所有 Java 提交中击败了 5.58% 的用户
     * @param n
     * @return
     */
    public int hammingWeight0(int n) {
        String s = Integer.toBinaryString(n);
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }


    /**
     * %2 == 1, /2
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.75% 的用户
     * 内存消耗 : 36.5 MB , 在所有 Java 提交中击败了 5.45% 的用户
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count=0;
        for (int i = 0; i < 32; i++) {
            if((n&1)==1){
                count++;
            }
            //负数的二进制都是反码，也就是大部分都是1，不能用while(n!=0) 判断
            n = n >> 1;
            System.out.println(n);
        }
        return count;
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.75% 的用户
     * 内存消耗 : 36.4 MB , 在所有 Java 提交中击败了 5.58% 的用户
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count=0;
        int mask=1;
        for (int i = 0; i < 32; i++) {
            if((n&mask)!=0){ //是比较十进制，不是二进制
                count++;
            }
            //把mask的1左移一位
            mask = mask << 1;
            //System.out.println(n);
        }
        return count;
    }

    /**
     * while（x > 0 ） {count ++; x = x & (x - 1)}
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.75% 的用户
     * 内存消耗 : 36.4 MB , 在所有 Java 提交中击败了 5.45% 的用户
     * @param n
     * @return
     */
    public int hammingWeight3(int n) {
        int count=0;
        //存在负数的情况，需要判断
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }


}
