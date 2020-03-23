/*位运算
 *
 */
class Solution {
public:
	int ans = 0;
    int totalNQueens(int n) {
		if ( n < 1 ) return 0;
		DFS(n, 0, 0, 0, 0);
		return ans;

    }
	void DFS(int n, int row, int col, int pie, int na){
		if ( row >= n){
			ans += 1;
			return ;
		}
		int bits = ( ~(col | pie | na) )& ((1<<n) -1 );
		while (bits){
			int p = bits & -bits; //取最低位低1
			bits = bits & (bits-1);
			DFS(n, row + 1,col | p, (pie|p) << 1, (na|p) >> 1);
		}
	}
};


