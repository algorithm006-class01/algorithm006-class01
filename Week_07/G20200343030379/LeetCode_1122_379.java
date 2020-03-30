package G20200343030379;

import java.util.TreeMap;

/**
 * 1122. 数组的相对排序
 *
 * 给你两个数组，arr1 和?arr2，
 *
 * arr2?中的元素各不相同
 * arr2 中的每个元素都出现在?arr1?中
 * 对 arr1?中的元素进行排序，使 arr1 中项的相对顺序和?arr2?中的相对顺序相同。未在?arr2?中出现过的元素需要按照升序放在?arr1?的末尾。
 *
 * ?
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * ?
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2?中的元素?arr2[i]?各不相同
 * arr2 中的每个元素?arr2[i]?都出现在?arr1?中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：
 */
public class LeetCode_1122_379 {

    public static void main(String[] args) {
        //十进制转二进制
        //String s = Integer.toBinaryString(-2147483648);
    }

    /**
     * 后半部可以利用计数排序，即数组内index作为排序依据
     *
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 38.4 MB , 在所有 Java 提交中击败了 5.40% 的用户
     *
     * 优秀题解：https://leetcode.com/problems/relative-sort-array/discuss/335056/Java-in-place-solution-using-counting-sort
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int cnt[]=new int[1001];
        for (int n : arr1) {
               cnt[n]++;
        }

        int count=0;
        for (int n : arr2) {
            while (cnt[n]-->0){
                arr1[count++]=n;
            }
        }

        //清理剩下没有出现在arr2的数
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i]-->0){
                arr1[count++]=i;
            }
        }
        return arr1;
    }


}
