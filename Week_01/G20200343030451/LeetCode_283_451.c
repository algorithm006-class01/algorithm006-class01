//283_move-zeroes.c
//代码文件命名规则：**LeetCode_题目序号_学号    Leetcode_283_451.c

void moveZeroes(int* nums, int numsSize){
    int i = 0,j = 0;
    for ( i = 0,j = 0; i < numsSize; i++ ) {
        if ( *(nums+i) != 0 && i != j ) {
            *(nums+j) = *(nums+i);
            *(nums+i) = 0;
            j++;

        } else if ( *(nums+i) != 0 && i == j) {
            j++;
        }
    }
}