package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三
//元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针
public class leetcode15 {
    public static void main(String[] args) {
        int[] ints = new int[]{-13,10,11,-3,8,11,-4,8,12,-13,5,-6,-4,-2,12,11,7,-7,-3,10,12,13,-3,-2,6,-1,14,7,-13,8,14,-10,-4,10,-6,11,-2,-3,4,-13,0,-14,-3,3,-9,-6,-9,13,-6,3,1,-9,-6,13,-4,-15,-11,-12,7,-9,3,-2,-12,6,-15,-10,2,-2,-6,13,1,9,14,5,-11,-10,14,-5,11,-6,6,-3,-8,-15,-13,-4,7,13,-1,-9,11,-13,-4,-15,9,-4,12,-4,1,-9,-5,9,8,-14,-1,4,14};
        // -5 -5 -4 -4 -3 -2 -2 0 0 1 2 2 2 2
        List<List<Integer>> lists = threeSum(ints);
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists = new LinkedList<>();
//        if (nums == null || nums.length < 3) return lists;
//        // 先对数组排序 否则在后面的从小到大添加到数组中存在问题
//        Arrays.sort(nums);//-4 -1 -1 0 1 2
        // 答案中不可以包含重复的三元组。
        // 思考 a + b = -c 类似两数之和 target = -c

        // 最优解法：通过一层循环来进行判断 优化循环嵌套 内部采用两个指针的方式进行 左右下标往中间推进
        // 注意 双指针一定是排序好的。
        // 排完序之后 首先进行边界判断 要实现 a + b+ c =0 那么nums[0] 一定是小于0的 nums[nums.length-1] 一定是大于0的否则这个数组就不能成立
        // 整个数组符号相同肯定是无解的
//        if (nums[0] <= 0 && nums[nums.length - 1] >= 0) {
//            for (int i = 0; i < nums.length - 2; i++) {
//                //移动左右下标
//                //优化边界 如果最最值为正值肯定无解 因为左右下标都在最左值的右边 肯定比最左值大
//                if (nums[i] > 0) break;
//                if (i > 0 && nums[i] == nums[i - 1]) continue;//对比完第一个以后移动i ++ 同时注意跳过重复的
//                int first = i + 1;
//                int last = nums.length - 1;
//                //-4 -1 -1 0 1 2 举例  first = 1 ; last = 5 first 和 last 重合时停止 开始查找
//                while (first < last) {
//                    int result = nums[i] + nums[first] + nums[last];
//                    if (result == 0) {
//                        lists.add(Arrays.asList(nums[i], nums[first], nums[last]));
//                        //注意去重之后 first还是之前的值，还需要+1 last还是之前的值，还需要-1
//                        while (first < last && nums[first] == nums[first + 1]) {
//                            first++;//first++还是之前的值
//                        }
//                        while (first < last && nums[last] == nums[last - 1]) {
//                            last--;//last--还是之前的值
//                        }
//                        //变换值
//                        first++;
//                        last--;
//                    } else if (result < 0) {
//                        //说明first的值较小 继续往右移动 同时如果first == first+1 跳过
//                        //去重
//                        while (first < last && nums[first] == nums[first + 1]) {
//                            first++;//first++还是之前的值
//                        }
//                        first++;
//                    } else {
//                        //说明last的值较大 继续往左移动 同时跳过重复的数据
//                        //去重
//                        while (first < last && nums[last] == nums[last - 1]) {
//                            last--;//last--还是之前的值
//                        }
//                        last--;
//                    }
//                }
//            }
//        }
        // 简化最优解法：
        List<List<Integer>> result = new LinkedList<>();
        if(nums==null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);//双指针法必须对数组进行排序
        for(int i = 0; i < nums.length - 2;i++){
            if(i==0 || (nums[i]!=nums[i-1])){
                int l = i+1;
                int r = nums.length - 1;
                while(l < r){
                    int target = nums[l] + nums[r] + nums[i];
                    if(target == 0){
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;
                        l++;r--;
                    }else if(target < 0){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return result;

        // hash表记录解法 ：将数组的值记录到hash表中 这种解法存在这一定的边界问题和重复问题判断相当麻烦
        // Map<Integer, Integer[]> map = new HashMap<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                if (map.get(nums[j]) != null) {
//                    Integer[] integers = map.get(nums[j]);
//                    List<Integer> nodeList = new ArrayList<>(Arrays.asList(integers));
//                    lists.add(nodeList);
//                    map.put(nums[j], null);
//                    //重复问题和边界问题如何解决？
//                } else {
//                    int traget = 0 - (nums[i] + nums[j]);//目标值
//                    Integer[] integers = new Integer[]{nums[i], nums[j],traget};
//                    Arrays.sort(integers);
//                    map.put(traget, integers);//存储着 key 目标值 value:两个数
//                }
//            }
//        }

        // 暴力破解法：通过三层循环来进行判断 但是LeetCode 会报超时 主要用于理解本题的逻辑 n ^ 3
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    //如何排除重复的呢？
//                    int result = nums[i] + nums[j] + nums[k];
//                    if (result == 0) {
//                        List<Integer> nodeList = new ArrayList<>();
//                        //i < j < k
//                        nodeList.add(nums[i]);
//                        nodeList.add(nums[j]);
//                        nodeList.add(nums[k]);
//                        lists.add(nodeList);
//                        //如果i的下一个和i相等 则跳过，因为结果是一样的
//                        //全是0 的情况如何解决？[0,0,0,0,0,0,0,0]
//                        while (i < nums.length - 2 && nums[i] == nums[i + 1]) {// 判断i 后面是否重复 如果重复 +1
//                            i = i + 1;
//                        }
//                        while (j < nums.length - 1 && nums[j] == nums[j + 1]) {// 判断j后面是否重复 如果重复 +1
//                            j = j + 1;
//                        }
//                        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {//判断k后面是否重复 如果重复 +1
//                            k = k + 1;
//                        }
//                        if (i == nums.length - 2) {// i 已经循环完毕
//                            return lists;
//                        }
//                    }
//                }
//            }
//        }
//        return lists;
    }
}
