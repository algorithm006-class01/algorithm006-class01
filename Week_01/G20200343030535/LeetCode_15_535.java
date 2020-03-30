package leetcode.Week01;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode_15_535 {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 思路1：暴力法
     * 思路2：哈希法 a+b+c=0,转换成 a+b = -c
     * 思路3：双指针（左右下标往中间推进）：
     * 双指针法铺垫： 先将给定 nums 排序，复杂度为O(NlogN)
     * 双指针法思路： 固定3 个指针中最左（最小）数字的指针 k，双指针 i，j 分设在数组索引(k,len(nums))
     * (k,len(nums)) 两端，通过双指针交替向中间移动，记录对于每个固定指针 k 的所有满足 nums[k] + nums[i] + nums[j] == 0 的 i,j 组合：
     * 当 nums[k] > 0 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即3 个数字都大于0 ，在此固定指针 k 之后不可能再找到结果了。
     * 当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
     * i，j 分设在数组索引(k,len(nums))
     * (k,len(nums)) 两端，当i < j时循环计算s = nums[k] + nums[i] + nums[j]，并按照以下规则执行双指针移动：
     * 当s < 0时，i += 1并跳过所有重复的nums[i]；
     * 当s > 0时，j -= 1并跳过所有重复的nums[j]；
     * 当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
     */
    /**
     * 遇到这个题目的话：将暴力法和哈希法和双指针法都概述一次，并且能写出如下的方法，那么的话基本ok了
     */

    /**暴力法:*/
    public static List<List<Integer>> threeSum1(int[] nums) {
        /**先排序*/
        Arrays.sort(nums);
        List<List<Integer>> dataList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        dataList.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    }
                }
            }
        }
        return dataList.stream().distinct().collect(Collectors.toList());
    }

    /**双指针（左右下标往中间推进）:*/
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        /**这里的前置++（--）和后置++（--）的效果是一样的，前置*/
        /**先排序*/
        Arrays.sort(nums);
        for (int k = 0; k <= nums.length - 3; k++) { /**k表示：-c的下标的位置*/
            if (nums[k] > 0) { break; }
            if (k > 0 && nums[k] == nums[k - 1]) { continue; }
            int i = k + 1;                      /**除了k的下标的位置开始的头指针*/
            int j = nums.length - 1;            /**尾指针*/
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]); /**移动下标*/
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> dataList = threeSum1(A);
        for (List<Integer> integers : dataList) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }

    }
}
