def merge(nums1, m, nums2, n):
    """
    :type nums1: List[int]
    :type m: int
    :type nums2: List[int]
    :type n: int
    :rtype: None Do not return anything, modify nums1 in-place instead.
    """
    i = 0
    x = 0
    nums1_copy = nums1[:m]
    nums1[:] = []
    while i < m and x < n:
        if nums1_copy[i] < nums2[x]:
            nums1.append(nums1_copy[i])
            i += 1
        else:
            nums1.append(nums2[x])
            x += 1

    if i < m:
        nums1 += nums1_copy[i:m]
    if x < n:
        nums1 += nums2[x:n]