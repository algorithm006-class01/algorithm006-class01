题目:并查集

class Solution {
public:
    int find(int x, vector<int>&pre){
        while(pre[x] !=x) x=pre[x];
        return x;
    }
public:
    int findCircleNum(vector<vector<int>>& M) {
        int N = M.size(),ans = N;
        vector<int>pre(N);
        for(int i =0;i<N;i++) pre[i]=i;
        for(int i = 0;i<N;i++){
            for(int j =0;j<N;j++){
                if(M[i][j]){
                    int lead1 = find(i,pre);
                    int lead2 = find(j,pre);
                    if(lead1!=lead2){
                        pre[lead2] = lead1;
                        ans--;
                    }
                }
            }
        }
        return ans;
    }
};
