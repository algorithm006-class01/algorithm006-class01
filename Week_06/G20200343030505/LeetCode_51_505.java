
class LeetCode_51_505 {
     private List<List<String>> result = new ArrayList();
    private int[] cols;//标记i列是否有棋子
    private int[] arr;//标记反斜对角线有棋子
    private int[] brr; //标记对角线是否有棋子
    private int[] queens;//标记第i,queens[i]位置是否有棋子
    private int n;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return result;
        }

        this.cols = new int[n];//列
        this.arr = new int[2 * n - 1];//斜对角线
        this.brr = new int[2 * n - 1];//反斜对角线
        this.n = n;
        this.queens = new int[n];//队列存放皇后位置
        solve(0);
        return result;
    }

    public void solve(int row) {
        if (row == n) {
            return;
        }
        //依次判断row和i位置是否能放棋子
        for (int i=0;i<n;++i) {
            if (isAblePlace(row, i)) {
                //标记位置
                signPlace(row, i);

                //找到合适的位置拼接结果
                if (row == n - 1) {
                    addResult();
                }

                //递归下一轮
                solve(row + 1);
                //删除标记
                deletePlace(row, i);
            }
        }
    }

    public boolean isAblePlace(int row, int colum) {
        int val = cols[colum] + arr[row - colum + n - 1] + brr[row + colum];
        return val == 0;
    }

    public void signPlace(int row, int colum) {
        cols[colum] = 1;
        arr[row - colum + n - 1] = 1;
        brr[row + colum] = 1;
        queens[row] = colum;
    }

    public void deletePlace(int row, int colum) {
        cols[colum] = 0;
        arr[row - colum + n - 1] = 0;
        brr[row + colum] = 0;
        queens[row] = 0;
    }

    public void addResult() {
        List<String> list = new ArrayList<String>();
        for (int i=0;i<n;++i) {
            int colum = queens[i];
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<n;++j) {
                if (j == colum) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        result.add(list);
    }
}