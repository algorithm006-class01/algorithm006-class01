package leetcode.Week01;

public class LeetCode_283_535 {

    /**
     *
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 思路1：暴力法              o(n^2)
     * 思路2：双指针法            o(n)
     */


    public static void moveZeroes(int[] nums) {
        int p1 = 0;  /**用来表示移动的下标的位置*/
        int p2 = 0;  /**用来表示要添加的下标的位置*/
        while (p1 < nums.length){
            if (nums[p1] != 0){
                /**当p1和p2相同的时候，就算本身和本身替换了，也没有关系，但是问题在于是否赋值为0的情况，当值不为0的时候，如果把值替换成0的话，就出问题了*/
                nums[p2] = nums[p1];
                if (p1 != p2) {
                    nums[p1] = 0;
                }
                p2++;
            }
            p1++;
        }
    }


    public static void moveZeroes3(int[] nums) {
        int[] A = new int[nums.length];
        int maxIndex = nums.length - 1;
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                A[maxIndex] = nums[i];
                maxIndex--;
            }else {
                A[minIndex] = nums[i];
                minIndex++;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int snowBallSize  = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                snowBallSize++;
            }else if (snowBallSize > 0){
                int t = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = t;
            }
        }
    }

    public static void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {0,1,0,3,12};
        moveZeroes(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ",");
        }
    }

}
