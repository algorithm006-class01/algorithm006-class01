解法一:
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int bit = 0;
        int mask = 1;
        for(int i =0;i<32;i++){
            if((n&mask) != 0){ //从最后一位为1进行与运算
                bit++;
            }
            mask = (unsigned int)mask << 1; //这里做一个无符号类型转换处理
        }
        
        return bit;
    }
};

解法二:
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int sum = 0;
        while(n!=0){
            sum ++;
            n&=(n-1); 
        }
        return sum;
    }
};
