/**
 * 使用栈
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:53:59
 */
class LeetCode_363_505 {
     public int search(int[] nums, int target) {
           
        if (matrix == null) {
            return 0;
            }

        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int colum = matrix[0].length;
        //确定左右边界 开始计算每一行的累计值 存在curSum数组里  然后计算该数组连续累积和 不超过k
        for (int i=0;i<colum;++i) {
            int[] curSum = new int[rows];
            for (int j=i;j<colum;++j) {
                for (int z=0;z<rows;++z) {
                    curSum[z] += matrix[z][j];
                }
                max = Math.max(max, maxSubArray(curSum, k));
            }
            
        }

        return max;
    }

    public int maxSubArray(int[] nums, int k) {
                int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;++i) {
            int sum = 0;
            for (int j=i;j<nums.length;++j) {
                sum += nums[j];
                if (sum > max && sum <= k) {
                    max = sum;
                }
            }
        }
        return max;
    }
}