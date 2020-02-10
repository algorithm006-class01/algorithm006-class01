// 第四次
// 想清楚了逻辑，简化了代码
int* plusOne(int* digits, int digitsSize, int* returnSize){

    if (digitsSize == 0) return ;

    for ( int i = digitsSize - 1; i >= 0; i-- ){
        digits[i]++;
        digits[i] = digits[i] % 10;
        if (digits[i] != 0 ) {
            *returnSize = digitsSize;
            return digits;
        }
    }

    int *res = (int *)malloc(sizeof(int) * (digitsSize+1));
    res[0] = 1;
    memcpy(res+1, digits, sizeof(int) * digitsSize);
    *returnSize =( digitsSize + 1);
    return res;

}

// 第三次
// 在第二次的代码上进行优化，中间只要不进位，就可以退出

int* plusOne(int* digits, int digitsSize, int* returnSize){

    if ( digitsSize == 0) return ; 

    // 从后往前
    // 先算最后一位
    int sum = digits[digitsSize - 1] + 1;
    digits[digitsSize-1] = sum % 10;
    int carry = sum / 10;
    for ( int i = digitsSize - 2; i >= 0; i--){
        sum = digits[i] + carry;
        digits[i] = sum % 10;
        carry = sum / 10;
        if ( carry == 0 ) {
            *returnSize = digitsSize ;
            return digits;
        }
    }

    if (carry != 0 ){
        int *res = (int *)malloc(sizeof(int) * (digitsSize+1));
        res[0] = carry;
        memcpy(res+1, digits, sizeof(int) * digitsSize);
        *returnSize =( digitsSize + 1);
        return res;
    }
    *returnSize = digitsSize;
    return digits ;


}



//第二次写的代码
int* plusOne(int* digits, int digitsSize, int* returnSize){

    if ( digitsSize == 0) return ; 

    // 从后往前
    // 先算最后一位
    int sum = digits[digitsSize - 1] + 1;
    digits[digitsSize-1] = sum % 10;
    int carry = sum / 10;
    for ( int i = digitsSize - 2; i >= 0; i--){
        sum = digits[i] + carry;
        digits[i] = sum % 10;
        carry = sum / 10;
    }
    if (carry > 0 ){
        int *res = (int *)malloc(sizeof(int) * (digitsSize+1));
        res[0] = carry;
        memcpy(res+1, digits, sizeof(int) * digitsSize);
        *returnSize =( digitsSize + 1);
        return res;

    }
    
    *returnSize = digitsSize ;
    return digits;

}

//第一次写的代码

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
