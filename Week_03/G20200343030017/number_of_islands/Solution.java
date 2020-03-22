package week3.number_of_islands;

public class Solution {
    int islandNum = 0;
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int y=0;y<grid.length;y++){
            for (int x=0;x<grid[y].length;x++){
                int level = 0;
                recursion(grid,y,x,level);
            }
            //System.out.println(Arrays.toString(grid[y]));
        }
        return islandNum;
    }
    public void recursion(char[][] grid,int y,int x,int level){
        if (y<0||x<0){
            return;
        }
        if (y>grid.length-1||x>grid[y].length-1){
            return;
        }
        if (grid[y][x]=='1'){
            grid[y][x]='0';
            if (level==0){
                islandNum++;
            }
            if (x==0){
                recursion(grid,y,x+1,++level);
            }else{
                recursion(grid,y,x-1,++level);
                recursion(grid,y,x+1,++level);
            }
            if (y==0){
                recursion(grid,y+1,x,++level);
            }else{
                recursion(grid,y+1,x,++level);
                recursion(grid,y-1,x,++level);
            }
        }else{
            return;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Solution s = new Solution();
        System.out.println(s.numIslands(grid));
    }
}
