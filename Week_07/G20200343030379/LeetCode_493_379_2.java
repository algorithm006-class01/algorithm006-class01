package G20200343030379;

import java.util.Arrays;

/**
 * 493. 翻转对
 *
 * 给定一个数组?nums?，如果?i < j?且?nums[i] > 2*nums[j]?我们就将?(i, j)?称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：覃超老师视频国际站题解
 */
public class LeetCode_493_379_2 {

    public static void main(String[] args) {
        new LeetCode_493_379_2().reversePairs(new int[]{2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647});
    }

    /**
     * 利用归并排序
     * 执行用时 : 88 ms , 在所有 Java 提交中击败了 28.35% 的用户
     * 内存消耗 : 49.1 MB , 在所有 Java 提交中击败了 94.44% 的用户
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    /**
     * https://u.geekbang.org/lesson/10?article=212223
     * 覃超老师 17:50 开始讲
     * 时间复杂度：arrays.sort排序*统计   n(logN) * logN
     * 时间复杂度：归并排序*统计     O(N) * logN
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int mergeSort(int[] nums, int left, int right) {
        if(left>=right) return 0;
        int mid=(left+right)/2;

        int cnt=mergeSort(nums,left,mid)+mergeSort(nums,mid+1,right);

        for(int i=left,j=mid+1;i<=mid;i++){
            while(j<=right && nums[i]/2.0>nums[j]){
                j++;
            }
            cnt+=j-(mid+1);
        }

        //时间复杂度 n（logn）
        Arrays.sort(nums,left,right+1);

        //如果是归并排序的是 O(N)
        return cnt;
    }



    /*private int mergeSort(int[] nums, int left, int right) {
        if(left>=right)return 0;
        int mid=(left+right)/2;
        //System.out.println(Arrays.toString(nums)+"=========left:"+left+"=====mid:"+mid+"======right="+right+"====");
        int cnt=mergeSort(nums,left,mid)+mergeSort(nums,mid+1,right);

        for(int i=left,j=mid+1;i<=mid;i++){
            while (j<=right && nums[i]/2.0>nums[j]){
                j++;
            }
            cnt+=j-(mid+1);
        }

        Arrays.sort(nums,left,right+1);
        //System.out.println("排序："+Arrays.toString(nums)+"=========left:"+left+"=====mid:"+mid+"======right="+right+"====");
        return cnt;
    }*/



   /* private int mergeSort(int[] nums, int left, int right) {
        if(left>=right) return 0;
        int mid=(right+left)/2;
        System.out.println(Arrays.toString(nums)+"=========left:"+left+"=====mid:"+mid+"======right="+right+"====");
        int cnt=mergeSort(nums,left,mid) +mergeSort(nums,mid+1,right);

        for (int i=left,j=mid+1;i<=mid;i++){
            while (j<=right && nums[i]/2.0 > nums[j]) {
                j++;
            }
            cnt+=j-(mid+1);
        }
        Arrays.sort(nums,left,right+1);
        System.out.println("排序："+Arrays.toString(nums)+"=========left:"+left+"=====mid:"+mid+"======right="+right+"====");
        return cnt;
    }*/


}
