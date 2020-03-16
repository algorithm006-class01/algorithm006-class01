package G20200343030379;

import org.omg.CORBA.IRObject;

import javax.swing.*;
import java.util.List;

/**
 *  33. 搜索旋转排序数组
 *
 *  假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组?[0,1,2,4,5,6,7]?可能变为?[4,5,6,7,0,1,2]?)。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回?-1?。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是?O(log?n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例?2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：
 *
 */
public class LeetCode_33_379 {
    public static void main(String[] args) {
        new LeetCode_33_379().search2(new int[]{4,5,6,7,0,1,2},0);
    }

    /**
     * 暴力法-还原
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return 1;
    }

    /**
     * 二分查找法
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例?2:
     *
     * 优秀题解：二分查找：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=0;
        while (left<=right){
            mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;

            }else if(nums[left] <= nums[mid]){
                //左半边单调递增
                //属于左半边的范围
                if(nums[left]<=target && nums[mid] > target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                //右半边单调递增

                // 判断是否在右半边的范围内
                if(nums[mid] < target && nums[right] >= target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }

        }
        return -1;
    }


}
