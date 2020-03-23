/*
 * @lc app=leetcode.cn id=37 lang=cpp
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
public:
    bitset<9> getPossibleStatus(int x,int y){
        return ~(rows[x]|cols[y]|cells[x/3][y/3]);
    }
    vector<int> getNext(vector<vector<char>>& board){
        vector<int> res;
        int mincount=10;
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[i].size();j++){
                if(board[i][j]!='.')
                    continue;
                auto cur=getPossibleStatus(i,j);
                if(cur.count()>=mincount)
                    continue;
                res={i,j};
                mincount=cur.count();
            }
        }
        return res;
    }
    void fillNum(int x,int y,int n,bool fillFlag){
        bitset<9> pick(1<<n);
        rows[x]=(fillFlag)?(rows[x]|pick):(rows[x]^pick);
        cols[y]=(fillFlag)?(cols[y]|pick):(cols[y]^pick);
        cells[x/3][y/3]=(fillFlag)?(cells[x/3][y/3]|pick):(cells[x/3][y/3]^pick);
    }
    bool dfs(vector<vector<char>>& board,int count){
        if(count==0)
            return true;
        auto next=getNext(board);
        auto bits=getPossibleStatus(next[0],next[1]);
        for(int n=0;n<bits.size();n++){
            if(!bits.test(n))
                continue;
            fillNum(next[0],next[1],n,true);
            board[next[0]][next[1]]=n+'1';
            if(dfs(board,count-1))
                return true;
            board[next[0]][next[1]]='.';
            fillNum(next[0],next[1],n,false);
        }
        return false;
    }
    void solveSudoku(vector<vector<char>>& board) {
        rows=vector<bitset<9>>(9,bitset<9>());
        cols=vector<bitset<9>>(9,bitset<9>());
        cells=vector<vector<bitset<9>>>(3, vector<bitset<9>>(3, bitset<9>()));

        int count=0;
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board[i].size();j++){
                count+=(board[i][j]=='.');
                if(board[i][j]=='.')
                    continue;
                int n=board[i][j]-'1';
                rows[i] |=(1<<n);
                cols[j] |=(1<<n);
                cells[i/3][j/3]|=(1<<n);
            }
        }
        dfs(board,count);

    }
    private:
        vector<bitset<9>> rows;
        vector<bitset<9>> cols;
        vector<vector<bitset<9>>> cells;
};
// @lc code=end

