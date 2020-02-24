//方法2: 3次反转
void rotate(int* nums, int numsSize, int k){
	k = k % numsSize;
	// 第一次反转
	int tmp;
	for (int i = 0 ; i < numsSize / 2; i++){
		tmp = nums[i];
		nums[i] = nums[numsSize-i-1];
		nums[numsSize-i-1] = tmp;
	}
	//第二次反转
	for (int i = 0 ; i < k / 2; i++){
		tmp = nums[i];
		nums[i] = nums[k-i-1];
		nums[k-i-1] = tmp;
	}
	//第三次反转
	for (int i = k ; i < (numsSize + k ) >> 1; i++){
		tmp = nums[i];
		nums[i] = nums[numsSize-i+k-1];
		nums[numsSize-i+k-1] = tmp;
	}
}
//方法1: 非原地算法
void rotate(int* nums, int numsSize, int k){

    k = k % numsSize;

    int *arr = (int *)malloc( sizeof(int) * numsSize);

    //移动后k个元素
    memcpy(arr, nums+(numsSize-k), sizeof(int) * k);
    //移动前numsSize-k个元素
    memcpy(arr+k, nums, sizeof(int) * (numsSize -k));

    memcpy(nums, arr, sizeof(int) * numsSize);
    free(arr);

}
