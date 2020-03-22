package G20200343030391;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_169_391 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 4};
        int i = new LeetCode_169_391().majorityElement_3(nums);
        System.out.println(i);
    }

    /**
     * 众数
     *
     * @param nums
     * @return
     */
    public int majorityElement_1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 哈希表
     *
     * @param nums
     * @return
     */
    public int majorityElement_2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.putIfAbsent(nums[i], 1);
            if (count != null) {
                count++;
                if (count >= 1.0 * nums.length / 2) {
                    return nums[i];
                } else {
                    map.put(nums[i], count);
                }
            }
        }
        return 0;
    }

    /**
     * 分治
     *
     * @param nums
     * @return
     */
    public int majorityElement_3(int[] nums) {
        return divide_conquer(nums, 0, nums.length - 1);
    }

    /**
     * 拆分数组，一个元素的数组直接返回唯一元素，两个子数组取到各自的组内的众数，
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int divide_conquer(int[] nums, int start, int end) {
        //terminator
        if (start == end) {
            return nums[start];
        }
        //prepare data
        int mid = (end - start) / 2 + start;
        //split problem
        int leftMost = divide_conquer(nums, start, mid);
        int rightMost = divide_conquer(nums, mid + 1, end);

        if (leftMost == rightMost) {
            return leftMost;
        }
        //merge result
        int leftCount = countInRange(nums, leftMost, start, mid);
        int rightCount = countInRange(nums, rightMost, mid + 1, end);
        return leftCount > rightCount ? leftMost : rightMost;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }


}
