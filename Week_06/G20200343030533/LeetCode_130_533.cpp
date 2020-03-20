#include <vector>

using namespace std;

struct DSU{
    std::vector<int> data;
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
        while (data[root] != root ){
            root = data[root];
        }
        int x;
        while ( data[i] != i){
            x = i;
            i = data[i];
            data[x] = root;
        }
        return root;
    };

};

/*
初始化并查集, 之后遍历最外圈
*/

class Solution {
private:
    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = { 0, 0,-1, 1};
public:
    void solve(vector<vector<char>>& board) {
        if ( board.size() == 0 ) return ;

        int rows = board.size();
        int cols = board[0].size();

        DSU dsu;
        dsu.makeSet( rows * cols + 1);
        int dummy = rows * cols; //虚拟节点作为边界0的父节点
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if ( board[i][j] == 'O'){
                    //边界
                    if ( i == 0 || i == rows - 1 || j == 0 || j == cols - 1){
                        dsu.unionSet( node(i,j,cols), dummy );
                    } else{
                        //无需边界检查
                        for (int k = 0; k < 4; k++){
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (board[nx][ny] == 'O'){
                                dsu.unionSet(node(nx, ny, cols), node(i,j,cols));
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if ( board[i][j] == 'O' && dsu.parent(node(i,j,cols)) != dsu.parent(dummy)){
                    board[i][j] = 'X';
                }
                //以下是错的
                // if ( dsu.parent(node(i,j,cols)) == dsu.parent(dummy)){
                //     board[i][j] = 'O';
                // } else{
                //     board[i][j] = 'X';
                // }
            }
        }

    }

    int node(int i, int j, int cols){
        return i * cols + j;
    }
};
