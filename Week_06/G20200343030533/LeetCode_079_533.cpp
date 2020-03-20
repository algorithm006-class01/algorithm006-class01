

bool find(char **board, int col, int row, int boardSize, int* boardColSize, chr *word){
    
}


bool exist(char** board, int boardSize, int* boardColSize, char * word){
    int x[4] = {-1, 1,  0, 0};
    int y[4] = { 0, 0, -1, 1};

    for (int i = 0; i < boardSize; i++){
        for (int j = 0; j < boardColSize[i]; j++){
            char c = board[i][j];
            if ( c == word[0] ){
            }
        }
    }

}