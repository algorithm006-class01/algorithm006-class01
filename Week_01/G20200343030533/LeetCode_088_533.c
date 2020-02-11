//方法2: 参考讨论写的代码
//从尾往前

void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
	int len = m + n ;
	for (int i = len - 1; i >= 0; i--){
		//下面这个条件语句是精髓
		//或语句前:在两个数组都没有到头时, 谁最大谁到最后
		//或语句后: 如果第二个数组结束了，那么后续只用处理第一个数组
		if ( ( m > 0 && n > 0 && nums1[m-1] > nums2[n-1] ) \
				|| n == 0) {
			nums1[i] = nums1[--m];
		} else{
			nums1[i] = nums2[--n];
		}
	}
}

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
