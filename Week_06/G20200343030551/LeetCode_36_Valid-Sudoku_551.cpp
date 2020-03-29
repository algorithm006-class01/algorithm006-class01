#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution
{
public:
    bool isValidSudoku(vector<vector<char>> &board)
    {
        unordered_map<char, int> row[9];
        unordered_map<char, int> col[9];
        unordered_map<char, int> sub[9];
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                char temp = board[i][j];
                int sub_index = (i / 3) * 3 + j / 3;
                if(temp!='.' && (row[i][temp]++ || col[j][temp]++ ||sub[sub_index][temp]++))
                    return false;
            }
        }
        return true;
    }
};