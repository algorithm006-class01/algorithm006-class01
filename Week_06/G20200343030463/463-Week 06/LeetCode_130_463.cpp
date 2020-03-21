学习笔记
class Solution {
    struct DSU {
        vector<int> data;
        
        void makeSet(int n){
            data.resize(n);
            for(int i =0; i< n; i++) data[i] = i;
        }
        
        bool unionSet(int i, int j){
            int p1 = parent(i);
            int p2 = parent(j);
            if(p1 != p2){
                data[p1] = p2;
            }
            return p1!=p2;
        }
        
        int parent(int i){
            int root = i;
            while(data[root] != root){
                root = data[root];
            }
            return root;
        }
        
    };
public:
    int dx[4] = {-1,1,0,0};
    int dy[4] = {0,0,-1,1};
    
    void solve(vector<vector<char>>& board) {
        if (board.size() == 0) return;
        int rows = board.size();
        int cols = board[0].size();
        
        DSU dsu;
        
        dsu.makeSet(rows*cols+1);
        int dummy = rows * cols;
        
        for(int i =0; i < rows; i++){
            for(int j =0; j < cols; j++){
                if(board[i][j]=='O'){
                    if(i ==0 || i ==rows-1 || j ==0 || j == cols -1){
                        dsu.unionSet(node(i,j,cols),dummy);
                    }else{
                        for(int k = 0; k < 4;k++){
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(board[nx][ny] == 'O'){
                                dsu.unionSet(node(nx,ny,cols),node(i,j,cols));
                            }
                        }
                    }
                }
            }
        }
        
        for(int i = 0;i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j]=='O' && dsu.parent(node(i,j,cols))!=dsu.parent(dummy)){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    int node(int i, int j, int cols){
        return i * cols +j;
    }
};
