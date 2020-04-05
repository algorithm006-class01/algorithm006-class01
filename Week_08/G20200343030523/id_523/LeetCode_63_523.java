package dynamic;

/**
 * @description: https://leetcode-cn.com/problems/unique-paths-ii/
 * @author: zhujiashuai
 * @date: 2020/4/5
 * @time: 9:07 下午
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < obstacleGrid.length; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        for (int j = 1; j < obstacleGrid[0].length; j++) {
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        UniquePathsII pathsII = new UniquePathsII();
        int[][] obstacleGrid = new int[3][3];
        obstacleGrid[0] = new int[]{0, 0, 0};
        obstacleGrid[1] = new int[]{0, 1, 0};
        obstacleGrid[2] = new int[]{0, 0, 0};
        System.out.println(pathsII.uniquePathsWithObstacles(obstacleGrid));
    }

}
