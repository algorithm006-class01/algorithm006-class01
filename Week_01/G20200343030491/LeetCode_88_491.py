def merge_pythonic(nums1,m,nums2,n):
    nums1 = nums1[:m]
    nums1.extend(nums2)
    nums1.sort()
    return nums1

def merge(nums1,m,nums2,n):
    while n > 0:
        if m<= 0 or nums1[m-1] <= nums2[n-1]:
            nums1[m+n-1] = nums2[n-1]
            n -= 1
        else:
           nums1[m+n-1] = nums1[m-1]
           m -= 1
    return nums1

def mergeRec(nums1,m,nums2,n):
    if n == 0:
        return 
    if m == 0:
        nums1[:n] = nums2[:n]
        return
    maxVal = max(nums1[m-1],nums2[n-1])
    nums1[m+n-1] = maxVal
    if (maxVal == nums1[m-1]):
        mergeRec(nums1,m-1,nums2,n)
    else:
        mergeRec(nums1,m,nums2,n-1)
    