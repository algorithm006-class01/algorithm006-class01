package cn.geek.week7;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月27日 21:19:00
 */
public class LeetCode_1122_363 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for(int num:arr1){
            bucket[num]++;
        }
        int i = 0;
        for(int num:arr2){
            while(bucket[num]-- > 0){
                arr1[i++] = num;
            }
        }
        for(int j = 0; j < 1001; ++j){
            while(bucket[j]-- > 0){
                arr1[i++] = j;
            }
        }
        return arr1;
    }
}
