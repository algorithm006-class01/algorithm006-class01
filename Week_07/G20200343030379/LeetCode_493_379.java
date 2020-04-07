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
 * 参考优秀题解：
 */
public class LeetCode_493_379 {

    /**
     * 归并排序
     *
     * 执行用时 : 72 ms , 在所有 Java 提交中击败了 45.87% 的用户
     * 内存消耗 : 52.9 MB , 在所有 Java 提交中击败了 16.67% 的用户
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        return merge2(nums,0,nums.length-1);
    }

    /**
     * 归并排序
     *
     * 执行用时 : 72 ms , 在所有 Java 提交中击败了 45.87% 的用户
     * 内存消耗 : 52.9 MB , 在所有 Java 提交中击败了 16.67% 的用户
     * @param nums
     * @return
     */
    public int reversePairs2(int[] nums) {
        return merge2(nums,0,nums.length-1);
    }

    private int merge2(int[] array, int left, int right) {
        if(left>=right) return 0;

        int mid= (right + left) >>1;
        int cnt=merge2(array,left,mid)+merge2(array,mid+1,right);

        for(int i=left,j=mid+1;i<=mid;i++){
            while (j<=right && array[i]/2.0 > array[j]) j++;
            cnt+= j-(mid+1);
        }

        //Arrays.sort(array,left,right+1);
        merge(array,left,mid,right);
        return cnt;
    }

    public static void main(String[] args) {
        /*int[] ints = new LeetCode_493_379().mergeSort(new int[]{3, 2, 34, 2}, 0, 3);
        System.out.println(Arrays.toString(ints));*/
        int mid1= 2+ (2) >>1;
        int mid2= 2+ (2) / 2;
        System.out.println(mid1);
        System.out.println(mid2);
    }

    public int[] mergeSort(int[] array,int left,int right){
        if(right<=left) return array;
        int mid=(left+right) >>1;

        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        return merge(array,left,mid,right);
    }

    private int[] merge(int[] array, int left, int mid, int right) {
        int[] temp=new int[right-left+1];
        int i = left ,j=mid+1,k=0;

        while(i<=mid && j<=right){
            temp[k++]=array[i] <=array[j] ? array[i++] :array[j++];
        }

        while (i<=mid) temp[k++] = array[i++];
        while (j<=right) temp[k++] = array[j++];

        for (int p=0;p<temp.length ; p++){
            array[left+p] =temp[p];
        }
        return array;
    }



}
