// https://leetcode-cn.com/problems/n-queens/description/

function solveNQueens(n) {
    var answers = [],
      upperlim = (1 << n) - 1,
      queens = [];
  
    function addSolution() {
      var answer = [];
      for (let i = 0; i < n; ++i) {
        let col = queens[i], sb = '';
        for (let j = 0; j < col; ++j) sb += '.';
        sb += 'Q';
        for (let j = 0; j < n - col - 1; ++j) sb += '.';
        answer.push(sb);
      }
      answers.push(answer);
    }
  
    function backtrack(col, ld, rd) {
      if (col === upperlim) {
        addSolution();
      } else {
        var pos = upperlim & ~(col | ld | rd);
        while (pos) {
          var current = pos & (~pos + 1);
          pos -= current;
          queens.push(n - 1 - Math.log2(current));
          backtrack(col | current, upperlim & (ld | current) >> 1, upperlim & (rd | current) << 1);
          queens.pop();
        }
      }
    }
  
    backtrack(0, 0, 0);
    return answers;
};