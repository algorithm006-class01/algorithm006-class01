package G20200343030379;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * 归并排序练习
 *
 *
 * 参考优秀题解：覃超老师视频国际站题解
 */
public class LeetCode_493_379_3 {


    public static void main(String[] args) {
        int[] aaa=new int[]{44,33,3, 2, 34,33, 2};
        int[] ints = new LeetCode_493_379_3().mergeSort(aaa, 0, aaa.length-1);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 归并排序
    */

    private int[] mergeSort(int[] nums, int left, int right) {
        if(right<=left) return nums;

        int mid =(left+right)/2;

        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        merger(nums,left,mid,right);

        return nums;
    }

    private void merger(int[] arr, int left, int mid, int right) {
        int[] temp=new int[right-left+1];
        int i=left,j=mid+1,k=0;

        while (i<=mid && j<=right){
            temp[k++]=arr[i]<=arr[j]?arr[i++]:arr[j++];
        }

        while (i<=mid)   temp[k++]=arr[i++];
        while (j<=right) temp[k++]=arr[j++];

        for (int p=0;p<temp.length;p++){
            arr[left+p]=temp[p];
        }
        return;
    }


}
