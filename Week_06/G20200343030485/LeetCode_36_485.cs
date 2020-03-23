public class Solution {
    public bool IsValidSudoku(char[,] board) {
        for (var i = 0; i < 9; i++)
        {
            var hsr = new HashSet<char>();
            var hsc = new HashSet<char>();
            var hsx = new HashSet<char>();

            for (var j = 0; j < 9; j++)
            {
                if (board[i, j] != '.' && !hsr.Add(board[i, j])) return false;
                if (board[j, i] != '.' && !hsc.Add(board[j, i])) return false;

                var x = (i % 3) * 3 + j % 3;
                var y = (i / 3) * 3 + j / 3;
                if (board[x, y] != '.' && !hsx.Add(board[x, y])) return false;
            }
        }

        return true;
    }
}