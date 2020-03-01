// https://leetcode-cn.com/problems/number-of-islands/

var numIslands = function(grid) {
    var count = 0
    if(grid.length === 0) return count;
    for(var i = 0; i < grid.length; i++){
        for(var j = 0; j < grid[0].length; j++){
            if(grid[i][j] === '1'){
                dfsSearch(grid,i,j)
                count++
            }
        }
    }
    return count;
};

function dfsSearch(grid,i,j){
    if(i < 0 || j < 0 || i >=grid.length || j >= grid[0].length) return;
    if(grid[i][j] === '1'){
        grid[i][j] = '0';
        dfsSearch(grid,i + 1,j);
        dfsSearch(grid,i - 1,j);
        dfsSearch(grid,i,j + 1);
        dfsSearch(grid,i,j - 1);
    }
};