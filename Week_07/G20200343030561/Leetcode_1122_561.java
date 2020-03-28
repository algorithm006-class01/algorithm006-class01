import java.util.*;
/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */


// @date Mar 27 2020
// class Solution {
//     public int[] relativeSortArray(int[] arr1, int[] arr2) {
//         int[] temp = new int[1001];
//         for (int i : arr1) 
//             temp[i] ++;
//         int i = 0;
//         for (int j : arr2) 
//             for (; temp[j] > 0; temp[j] --) 
//                 arr1[i++] = j;
//         for (int k = 0; k < 1001; k ++)
//             for (; temp[k] > 0; temp[k] --)
//                 arr1[i++] = k;
//         return arr1;
//     }
// }

// class Solution {
//     public int[] relativeSortArray(int[] arr1, int[] arr2) {
//         List<Integer> lst1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
//         List<Integer> lst2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
//         Collections.sort(lst1, new Comparator<Integer>() {
//             @Override
//             public int compare(Integer int1, Integer int2) {
//                 int idx1 = lst2.indexOf(int1);
//                 int idx2 = lst2.indexOf(int2);
//                 if (idx1 == -1 && idx2 == -1)
//                     return int1 - int2;
//                 return (idx1 != -1 & idx2 != -1) ? idx1 - idx2 : idx2;
//             }
//         });
//         return lst1.stream().mapToInt(Integer::intValue).toArray();
//     }
// }

// class Solution {
//     public int[] relativeSortArray(int[] arr1, int[] arr2) {
//         List<Integer> lst1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
//         List<Integer> lst2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
//         Collections.sort(lst1, (Integer int1, Integer int2) -> {
//             int idx1 = lst2.indexOf(int1);
//             int idx2 = lst2.indexOf(int2);
//             if (idx1 == -1 && idx2 == -1)
//                 return int1 - int2;
//             return (idx1 != -1 & idx2 != -1) ? idx1 - idx2 : idx2;
//         });
//         return lst1.stream().mapToInt(Integer::intValue).toArray();
//     }
// }

// @lc code=start
// @date Mar 28 2020
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] buckle = new int[1001];
        for (int i : arr1)
            buckle[i] ++;
        int i = 0;
        for (int j : arr2)
            for (; buckle[j] > 0; buckle[j] --)
                arr1[i++] = j;
        for (int k = 0; k < 1001; k ++)
            for (; buckle[k] > 0; buckle[k] --)
                arr1[i++] = k;
        return arr1;
    }
}
// @lc code=end
