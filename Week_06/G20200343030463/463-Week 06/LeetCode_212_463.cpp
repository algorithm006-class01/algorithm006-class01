学习笔记
class Solution {
private:
struct TrieNode {
    
unordered_map<char, TrieNode*> leaves;

string word = "";

TrieNode() {}
};
TrieNode* _root;
vector<vector<char> > _board;
vector<string> _result;

public:

vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
int row_size = (int)board.size();

this->_root = new TrieNode();
    
    for (const auto& word : words){
        TrieNode* node = this->_root;
        for (const auto& letter : word){
            auto it = node->leaves.find(letter);
            auto end = node->leaves.end();
            if (it != end)
                node = node->leaves[letter];
            else{
                TrieNode* new_node = new TrieNode();
                node->leaves.emplace(letter, new_node);
                node = new_node;
            }
        }
        node->word = word;
    }

    this->_board = board;

    for (int row = 0; row < row_size; ++row){
        for (int col = 0; col < board[row].size(); ++col){
            auto it = this->_root->leaves.find(board[row][col]);
            auto end = this->_root->leaves.end();
            if (it != end)
            backtracking(row, col, this->_root);
        }
    }
        return this->_result;
    }

void backtracking(int row, int col, TrieNode* parent) {
    char curr_letter = this->_board[row][col];

    TrieNode* curr_node = parent->leaves[curr_letter];
    if (curr_node->word != ""){
        this->_result.emplace_back(curr_node->word);
        curr_node->word = "";
    }

    this->_board[row][col] = '#';

    vector<int> row_offset = {-1, 0, 1, 0};
    vector<int> col_offset = {0, 1, 0, -1};

    for (int i = 0; i < 4; ++i) {
        int new_row = row + row_offset[i];
        int new_col = col + col_offset[i];

        if (new_row < 0 || new_row >= this->_board.size() || new_col < 0
|| new_col >= this->_board[0].size()) {
            continue;
}

        auto it = curr_node->leaves.find(this->_board[new_row][new_col]);
        auto end = curr_node->leaves.end();
        if (it != end)
            backtracking(new_row, new_col, curr_node);
    }

    this->_board[row][col] = curr_letter;

    if (curr_node->leaves.empty()) {
        parent->leaves.erase(curr_letter);
        }
    }
};
