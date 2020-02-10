//方法1: 先把元素加入到最后，然后排序
//时间复杂度O(nlog n), 空间复杂度O(n)
int cmp(const void *a, const void *b){
    return *(int*)a - *(int*)b;
}

void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){

    int i = m;
    int j = 0;
    while ( j < nums2Size){
        nums1[i] = nums2[j];
        i++;
        j++;
    }
    qsort(nums1, m+n, sizeof(int), cmp);
    return nums1;
}
