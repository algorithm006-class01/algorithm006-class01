/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */

// class Solution {
//     public int reversePairs(int[] nums) {
//          return mergeSort(nums, 0, nums.length - 1);
//     }
//     int mergeSort(int[] nums, int s, int e) {
//         if (s >= e) return 0;
//         int mid = s + (e - s) / 2;
//         int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
//         for (int i = s, j = mid + 1; i <= mid; i ++) {
//             while (j <= e && nums[i] / 2.0 > nums[j]) j ++;
//             cnt += j - (mid + 1);
//         }
//         Arrays.sort(nums, s, e + 1);
//         return cnt;
//     }
// }

// class Solution {
//     int res;
//     public int reversePairs(int[] nums) {
//         res = 0;
//         mergeSort(nums, 0, nums.length - 1);
//         return res;
//     }
//     void mergeSort(int[] nums, int left, int right) {
//         if (left >= right) return;
//         int mid = left + (right - left) / 2;
//         mergeSort(nums, left, mid);
//         mergeSort(nums, mid + 1, right);
//         int cnt = 0;
//         for (int l = left, r = mid + 1; l <= mid;) {
//             if (r > right || nums[l] / 2.0 <= nums[r]) {
//                 l ++;
//                 res += cnt;
//             } else {
//                 r ++;
//                 cnt ++;
//             }
//         }
//         int[] temp = new int[right - left + 1];
//         for (int l = left, r = mid + 1, i = 0; l <= mid || r <= right;) 
//             temp[i++] = (l <= mid && ((r > right) || nums[l] < nums[r])) ? nums[l++] : nums[r++];
//         for (int i = 0; i < temp.length; i ++) 
//             nums[left + i] = temp[i];
//     }
// }

// class Solution {
//     public int reversePairs(int[] nums) {
//         return mergeSort(nums, 0, nums.length - 1);
//     }
//     int mergeSort(int[] nums, int start, int end) {
//         if (end - start < 1) return 0;
//         int mid = start + (end - start) / 2;
//         int cnt = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
//         for (int l = start, r = mid + 1; l <= mid; l ++) {
//             while(r <= end && nums[l] / 2.0 > nums[r]) r ++;
//             cnt += r - (mid + 1);
//         }
//         int[] temp = new int[end - start + 1];
//         for (int l = start, r = mid + 1, i = 0; l <= mid || r <= end;) {
//             temp[i ++] = l <= mid && (r > end || nums[l] < nums[r]) ? nums[l ++] : nums[r ++];
//         }
//         for (int i = 0; i < temp.length; i ++) {
//             nums[start + i] = temp[i];
//         }
//         return cnt;
//     }
// }

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    int mergeSort(int[] nums, int start, int end) {
        if (end - start < 1) return 0;
        int mid = start + (end - start) / 2;
        int cnt = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        int[] temp = new int[end - start + 1];
        int l = start, i = 0, r = mid + 1, pivot = start;
        while (r <= end) {
            while(pivot <= mid && nums[pivot] / 2.0 <= nums[r]) pivot ++;
            while(l <= mid && nums[l] < nums[r]) temp[i++] = nums[l++];
            temp[i++] = nums[r++];
            cnt += mid + 1 - pivot;
        }
        while (l <= mid) temp[i++] = nums[l++];
        System.arraycopy(temp, 0, nums, start, end - start + 1);
        return cnt;
    }
}

// @lc code=end

