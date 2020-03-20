#include <vector>

using namespace std;

struct DSU{
    vector<int> data;

    void makeSet(int n){
        data.resize(n);
        for (int i = 0; i < n; i++) data[i] = i;
    };

    bool unionSet(int i, int j){
        int p1 = parent(i);
        int p2 = parent(j);
        if ( p1 != p2 ){
            data[p1] = p2;
        } 
        return p1 != p2;

    };

    int parent(int i){
        int root = i;
        while ( data[root] != root){
            root = data[root];
        }
        return root;

    };
};

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size() == 0 ) return  0;

        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1') ans++;
            }
        }
        DSU dsu;
        dsu.makeSet( m * n);
        for (int i = 0 ; i < m ; i++){
            for ( int j = 0; j < n ; j++){
                //检查当前元素和上一个元素
                if ( i > 0 && grid[i][j] == '1' && grid[i-1][j] == '1'){
                    ans -= dsu.unionSet(i*n +j, (i-1)*n+j);
                }
                //检查当前元素和左边元素
                if ( j > 0 && grid[i][j] == '1' && grid[i][j-1] == '1'){
                    ans -= dsu.unionSet(i*n +j, i*n+j-1);
                }

            }
        }
        return ans;

    }
};;