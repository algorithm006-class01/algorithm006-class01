import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // List<Integer> not_in = new ArrayList<>();
        // Map<Integer, Integer> arrCount = new HashMap<>();
        // for (int i : arr2) arrCount.put(i, 0);
        // for (int i : arr1){
        //     if (arrCount.containsKey(i)) arrCount.put(i, arrCount.get(i)+1);
        //     else not_in.add(i);
        // }
        // List<Integer> res = new ArrayList<>();
        // for (int i : arr2){
        //     int temp = arrCount.get(i);
        //     for(int j = 0; j < temp; ++j) res.add(i);
        // }

        // Collections.sort(not_in);
        // for (int i : not_in) res.add(i);
        // int[] resArr = new int[res.size()];
        // for (int i = 0; i < res.size(); ++i) resArr[i] = res.get(i);
        // return resArr;

        // 国内站牛牛的方案
        int[] nums = new int[1001];
        int[] res = new int[arr1.length];
        //遍历arr1,统计每个元素的数量
        for (int i : arr1) {
            nums[i]++;
        }
        //遍历arr2,处理arr2中出现的元素
        int index = 0;
        for (int i : arr2) {
            while (nums[i]>0){
                res[index++] = i;
                nums[i]--;
            }
        }
        //遍历nums,处理剩下arr2中未出现的元素
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0){
                res[index++] = i;
                nums[i]--;
            }
        }
        return res;
    }
}
// @lc code=end

