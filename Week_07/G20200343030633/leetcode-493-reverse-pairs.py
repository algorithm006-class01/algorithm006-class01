# public class Solution {
#     public int reversePairs(int[] nums) {
#         if (nums == null || nums.length == 0) return 0;
#         return mergeSort(nums, 0, nums.length - 1);
#     }
#     private int mergeSort(int[] nums, int l, int r) {
#         if (l >= r) return 0;
#         int mid = l + (r - l)/2;
#         int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
#         int[] cache = new int[r - l + 1];
#         int i = l, t = l, c = 0;
#         for (int j = mid + 1; j <= r; j++, c++) {
#             while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
#             while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
#             cache[c] = nums[j];
#             count += mid - i + 1;
#         }
#         while (t <= mid) cache[c++] = nums[t++];
#         System.arraycopy(cache, 0, nums, l, r - l + 1);
#         return count;
#     }
# }
def reversePairs(nums):
    if len(nums) == 0:
        return 0
    return mergesort(nums, 0, len(nums) - 1)


def mergesort(nums, l, r):
    if l >= r:
        return 0
    mid = l + (r - l) / 2
    count = mergesort(nums, l, mid) + mergesort(nums, mid + 1, r)
    cache = [0] * (r - l + 1)
    i = l
    t = l
    c = 0
    for j in range(mid + 1, r + 1):
        while i <= mid and nums[i] <= 2 * nums[j]:
            i += 1
        while t <= mid and nums[t] < nums[j]:
            cache[c] = nums[t]
            c += 1
            t += 1
        cache[c] = nums[j]
        count += mid - i + 1
        j += 1
        c += 1
    while t <= mid:
        cache[c] = nums[t]
        c += 1
        t += 1

    for i in range(r - l + 1):
        cache[i] = nums[l + i]
    return count
