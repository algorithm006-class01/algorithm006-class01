class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        int ans = 0;
        for (int i = 0 ; i < 32; i++){
            ans <<= 1;
            ans += (n & 0x1);
            n >>= 1;
            
        }
        return ans;
        
    }
};

/*
ans左移，加上0/1
然后原数字右移
*/
