class LeetCode_7_029{

	public static void main(String[] args){
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {

		if(null == grid || grid.length == 0) {
			return 0;
		}

		int landNum = 0;

		for(int r = 0; r < grid.length; r++){
			for(int c = 0; c < grid[0].length; c++){
				if(grid[r][c] == '1'){
					// 深度优先，将改节点周边为1的节点修改为0
					dfs(r,c,grid);
					landNum++;
				}
			}
		}
		return landNum;
	}

	public static void dfs(int r, int c, char[][] grid) {

		if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
			return;
		}

		grid[r][c] = '0';
		dfs(r - 1, c, grid);
		dfs(r + 1, c, grid);
		dfs(r, c - 1, grid);
		dfs(r, c + 1, grid);
	}
}