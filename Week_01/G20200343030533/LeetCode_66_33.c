/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){

    // 如果末尾小于9
    if (digits[digitsSize - 1] < 9){
        *returnSize = digitsSize;
        digits[digitsSize-1]+=1;
        return digits;
    }
    //否则要从后往前计算
    //进位
    int carry = 1;
    for ( int i = digitsSize - 1; i >= 0; i--){
        if (carry){
            digits[i] += 1;
            carry = 0;
        }
        if ( digits[i] > 9){
            digits[i] = digits[i]  -10;
            carry = 1;
        }
    }
    if ( carry == 0) {
         *returnSize =digitsSize;
         return digits;
    }
    *returnSize = digitsSize + 1;
    int *res = (int*)malloc( sizeof(int) * *returnSize);
    res[0] = 1;
    memcpy(res+1, digits, sizeof(int) * digitsSize);
    return res;
}
