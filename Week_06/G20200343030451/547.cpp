
class UF
{
public:
   
    UF(int n)
    {
        count = n;
        parent.resize(n);
        size.resize(n);
        for(int i = 0; i < n; i++)
        {
            parent[i] =i;
            size[i] = 1;
        }
    }

    void Union(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ)
            return;
        
        if(size[rootP] > size[rootQ])
        {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        else
        {
            parent[rootP] = rootQ;
            size[rootQ] += rootP;
        }
        count--;
    }

    bool connected(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP==rootQ;
    }

    int count_num()
    {
        return count;
    }
private:
    int count;
    vector<int> parent;
    vector<int> size;
    int find(int x)
    {
        while(parent[x] != x)
        {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
};

class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {

        if(M.size()==0)
            return 0;
        
        int m = M.size();
        int n = M[0].size();
        UF* uf = new UF(m);
        for(int i = 0; i < m; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                if(M[i][j] == 1)
                {
                    uf->Union(i,j);
                }
            }
        }
        return uf->count_num();
    }
};