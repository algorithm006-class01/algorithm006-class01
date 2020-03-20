#include <vector>

using namespace std;

/*
并查集的两种实现思想:

方案1: 将值初始化为-1, 大于0则表示指向另一个组织者

方法2: 将值初始化为索引，如果值不等于索引，说明指向另外的组织者

*/


struct DSU{
    //init, -1 表示独立, 不为0 记录的是group leader
    std::vector<int> data;
    void makeSet(int n) { data.assign(n, -1 );}
    //union
    bool unionSet(int x, int y){
        x = root(x);
        y = root(y);
        if ( x != y){
            if (data[y] < data[x]){
                std::swap(x,y);
            }
            data[x] += data[y]; //越负，圈子人越多
            data[y] = x;
        }
        return x !=y ;
    }

    bool same(int x, int y) { return root(x) == root(y); }

    //递归, 查找group leader
    int root(int x) {
        return data[x] < 0 ? x : data[x] = root(data[x]);
    }

    int size( int x) { return -data[root(x)];}
};

struct DSU2{
    std::vector<int> data;
    void makeSet(int n){
        data.resize(n);
        for (int i = 0 ; i < n; i++) data[i] = i;
    }
    bool unionSet(int i, int j){
        int p1 = parent(i);
        int p2 = parent(j);
        if ( p1 != p2){
            data[p1] = p2;
        }
        return p1 != p2;

    }

    int parent(int i){
        int root = i;
        while ( data[root] != root){
            root = data[root];
        }
        //路径压缩
        while ( data[i] != i){
            int x = i;
            i = data[i];
            data[x] = root;
        }
        return root;
    }
};

class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        int ans = M.size();
        DSU2 dsu;
        dsu.makeSet(M.size());
        for (size_t i = 0; i < M.size(); i++){
            for (size_t j = i+1; j < M.size(); j++){
                if (M[i][j] == 0 ) continue;
                ans -= dsu.unionSet(i,j);
            }
        }
        return ans;
    }
};
