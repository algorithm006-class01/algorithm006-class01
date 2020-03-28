package week7.relative_sort_array;

import java.util.Arrays;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[1000];
        for (int n=0;n<arr1.length;n++){
            temp[arr1[n]]++;
        }
        int len = 0;
        for (int n=0;n<arr2.length;n++){
            for (int j=0;j<temp[arr2[n]];j++){
                arr1[len]=arr2[n];
                len++;
            }
            temp[arr2[n]]=0;
        }
        int len1 = 1;
        for (int n=0;n<temp.length;n++){
            while (temp[n]>0){
                arr1[len-1+len1]=n;
                temp[n]--;
                len1++;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        Solution s = new Solution();
        int[] aaa = s.relativeSortArray(arr1,arr2);
        System.out.println(Arrays.toString(aaa));
    }
}
