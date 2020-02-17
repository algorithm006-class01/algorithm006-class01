class Solution:
    def trap(self, arr):
        left = right = water = 0
        i, j = 0, len(arr) - 1
        while i <= j:
            left, right = max(left, arr[i]), max(right, arr[j])
            while i <= j and arr[i] <= left <= right:
                water += left - arr[i]
                i += 1
            while i <= j and arr[j] <= right <= left:
                water += right - arr[j]
                j -= 1
        return water
