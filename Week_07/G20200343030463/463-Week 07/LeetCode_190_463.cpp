学习笔记
暴力求解:数组前后转换
class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        bitset<32> bs{n};
        int l{0}, r{31};
        while(l < r) {
            bool tmp = bs[l];
            bs[l++] = bs[r];
            bs[r--] = tmp;
        }
        return bs.to_ulong();
    }
};
位运算: 获取到n的最后一位将其移动到最高位,每次n都要右移一位将最后一个数清除 最后将结果加起来 移动位数也要减一


class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        int ans = 0;
        for(int bitSize =31;n!=0;n>>=1,bitSize--){
            ans +=(n&1)<<bitSize;
        }
        return ans;
    }
};
