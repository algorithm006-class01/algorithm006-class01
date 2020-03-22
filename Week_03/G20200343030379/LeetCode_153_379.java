package G20200343030379;

import java.util.Arrays;

/**
 *  153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组?[0,1,2,4,5,6,7] 可能变为?[4,5,6,7,0,1,2]?)。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：
 *
 */
public class LeetCode_153_379 {

    /**
     * 排序法
     *
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 26.08% 的用户
     * 内存消耗 : 38 MB , 在所有 Java 提交中击败了 32.06% 的用户
     *
     * @return
     */
    public int findMin(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        return nums[0];
    }

    /**
     * 二分查找法，两边不断夹逼接近最小值
     *
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 38 MB , 在所有 Java 提交中击败了 32.24% 的用户
     *
     * 优秀题解：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-by-powcai-2/
     *
     * @return
     */
    public int findMin2(int[] nums) {
        int left=0,right=nums.length-1;
        int mid=0;
        //如果两个值相等即可退出，这种判断叫循环外输出，就是由外部return。否则叫循环内输出，在循环内return返回
        while (left<right){
            mid = (left + right) / 2;

            //右边单调递增,说明最小在左半边
            if(nums[mid] < nums[right]){
                right = mid  ;
            }else{
                //不需要减1
                left = mid + 1 ;
            }
        }

        //left right 返回都可以
        return nums[left];
    }


}
