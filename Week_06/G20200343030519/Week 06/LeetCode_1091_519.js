// https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/

var shortestPathBinaryMatrix = function(grid) {  
  if (grid[0][0]) return -1;
  
  const queue = [{ coord: [0, 0], dist: 1 }];
  const directs = [[-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1]];
  const N = grid.length;
  const isValidCoord = (x, y) => x >= 0 && x < N && y >= 0 && y < N;
  
  grid[0][0] = 1;
  
  while (queue.length) {
    const { coord: [x, y], dist } = queue.shift();
    
    if (x === N - 1 && y === N - 1) {
      return dist;
    }
    
    for (let [moveX, moveY] of directs) {
      const nextX = x + moveX;
      const nextY = y + moveY;
      
      if (isValidCoord(nextX, nextY) && grid[nextX][nextY] === 0) {
        queue.push({ coord: [nextX, nextY], dist: dist + 1 });
        grid[nextX][nextY] = 1;
      }
    }
  }
  
  return -1;
};