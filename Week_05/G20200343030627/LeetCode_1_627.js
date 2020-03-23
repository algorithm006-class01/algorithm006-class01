// minimum-path-sum

var minPathSum = function(grid) {
    if (grid.length == 0) {
        return 0
    }

    var record = [];
    var i,j;
    for (i=0; i<grid.length; i++) {
        record[i] = [];
        for (j=0; j<grid[0].length; j++) {
            if (i==0) {
                record[i][j] = grid[i][j] + (j==0 ? 0: record[i][j-1]);
            } else if (j==0) {
                record[i][j] = grid[i][j] + (i==0 ? 0 : record[i-1][j]);
            } else {
                record[i][j] = Math.min(record[i-1][j], record[i][j-1]) + grid[i][j];
            }           
        }
    }

    return record[i-1][j-1]
};