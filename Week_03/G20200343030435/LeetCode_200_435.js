var numIslands = function(grid) {
  if (!grid || grid.length == 0) {
    return 0;
  }
  var len = grid.length;
  var size = grid[0].length;
  var island = 0;
  function sink(i, j) {
    // terminator
    if (grid[i][j] == "0") {
      return 0;
    }
    // process
    grid[i][j] = "0";
    // drill down
    if (i + 1 < len && grid[i + 1][j] == "1") {
      sink(i + 1, j);
    }
    if (i - 1 >= 0 && grid[i - 1][j] == "1") {
      sink(i - 1, j);
    }
    if (j + 1 < size && grid[i][j + 1] == "1") {
      sink(i, j + 1);
    }
    if (j - 1 >= 0 && grid[i][j - 1] == "1") {
      sink(i, j - 1);
    }
    return 1;
  }
  for (var i = 0; i < len; i++) {
    for (var r = 0; r < grid[i].length; r++) {
      if (grid[i][r] == "1") {
        island += sink(i, r);
      }
    }
  }
  return island;
};
