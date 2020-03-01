// https://leetcode-cn.com/problems/minesweeper/description/

var updateBoard = function(board, click) {
    let x = click[0];
    let y = click[1];
    // 踩中地雷
    if(board[x][y] == 'M'){
        board[x][y] = 'X';
        return board;
    }
    let dx = [-1, -1, -1, 1, 1, 1, 0, 0];
    let dy = [-1, 1, 0, -1, 1, 0, -1, 1];
    // 获取当前节点相邻的地雷数量
    let getNumsBombs = (board,x,y) => {
        let num = 0;
        for(let i = 0;i < 8;i++){
            let newX = x + dx[i];
            let newY = y + dy[i];
            if(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length){
                continue;
            }
            // 八大方向中的其中一点如果是M或者X 说明有地雷
            if(board[newX][newY] == 'M' || board[newX][newY] == 'X'){
                num++;
            }
        }
        return num;
    }
    let dfs = (board,x,y) => {
        // 边界 当前点的横、纵坐标不能小于0，不能大于一维、二维长度
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E'){
            return;
        }
        let num = getNumsBombs(board,x,y);
        if(num == 0){ // 如果为0则进行递归 无地雷继续递归
            board[x][y] = 'B';
            for(let i = 0;i < 8;i++){
                let newX = x + dx[i];
                let newY = y + dy[i];
                dfs(board,newX,newY);
            }
        }else{ // 不为0则更新当前节点的值为地雷数量 有地雷
            board[x][y] = num + '';
        }
    }
    dfs(board,x,y);
    return board;
 };