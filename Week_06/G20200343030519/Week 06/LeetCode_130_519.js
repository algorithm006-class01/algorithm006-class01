// https://leetcode-cn.com/problems/surrounded-regions/

function solve(board) {
    if (!board.length) return;
  
    for (let i = 0; i < board.length; i++) {
      mark(board, i, 0);
      mark(board, i, board[0].length - 1);
    }
  
    for (let i = 1; i < board[0].length - 1; i++) {
      mark(board, 0, i);
      mark(board, board.length - 1, i);
    }
  
    for (let i = 0; i < board.length; i++) {
      for (let j = 0; j < board[0].length; j++) {
        if (board[i][j] === 'O') board[i][j] = 'X';
        if (board[i][j] === '#') board[i][j] = 'O';
      }
    }
  }
  
  function mark(board, i ,j) {
    if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) return;
    if (board[i][j] !== 'O') return;
  
    board[i][j] = '#';
    
    mark(board, i - 1, j);
    mark(board, i + 1, j);
    mark(board, i, j - 1);
    mark(board, i, j + 1);
  }