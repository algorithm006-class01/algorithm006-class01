/* 涉及到的位运算技巧
 1. 获取最低位的1, p = x&-x
 2. 将最高位到第n位清零， x & ( (1<<n) - 1)
 3. 打掉最后一位的1 x = x & (x-1)
*/

class Solution {
    int count = 0;
public:
    int totalNQueens(int n) {
        if (n < 1) return 0;
        DFS(n, 0, 0, 0, 0);
        return count;
    }
    void DFS(int n, int row, int col, int pie, int na){
        if ( n == row){
            count+=1;
            return;
        }
        
        int bits = (~ (col | pie | na) ) & ( (1 << n) -1);
        while (bits){
            int p = (bits & -bits);
            bits = bits - p;
            DFS(n, row+1, col | p, (pie|p) << 1, (na|p) >> 1);
        }
        return ;
    }
};