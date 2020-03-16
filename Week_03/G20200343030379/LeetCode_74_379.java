package G20200343030379;

/**
 *  74. 搜索二维矩阵
 *
 * 编写一个高效的算法来判断?m x n?矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例?1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例?2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：
 *
 */
public class LeetCode_74_379 {

    /**
     * 二分查找法：
     *
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 41.5 MB , 在所有 Java 提交中击败了 47.05% 的用户
     *
     * 优秀题解：https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode/
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowN = matrix.length;
        if(rowN == 0) return false;

        //有多少列
        int colM=matrix[0].length;


        int left=0,right=rowN * colM - 1;
        //存储行，列
        int row=0,col=0;
        int mid=0;
        while (left <= right){
            mid=(left + right)/2;
            row = mid / colM;
            col = mid % colM;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }
        return false;
    }

    /**
     * 迭代法：从右上角开始迭代
     *
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 39.32% 的用户
     * 内存消耗 : 41.5 MB , 在所有 Java 提交中击败了 48.48% 的用户
     *
     * 优秀题解：https://leetcode.com/problems/search-a-2d-matrix/discuss/26215/An-Easy-Solution-in-Java
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row=0;
        if(matrix.length==0) return false;
        int col=matrix[0].length-1;

        while(row < matrix.length && col >= 0){
            System.out.println(row+"--"+col+"=="+matrix[row][col]);
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                //大于目标值，缩进
                col --;
            }else{
                //小于目标值，换到下一行
                row ++;
            }
        }
        //都查找失败，返回false
        return false;
    }


}
