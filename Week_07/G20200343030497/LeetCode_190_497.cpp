class Solution {
public:
    // 时间复杂度：O(1)
    // 空间复杂度：O(1)
    uint32_t reverseBits(uint32_t n) {
        uint32_t result= 0;
        for(int i=0; i<32; i++)
            result = (result << 1) + (n >> i & 1);
        
        return result;
    }
};
