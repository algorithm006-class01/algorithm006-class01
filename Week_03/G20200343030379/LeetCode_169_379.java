package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *  169. 多数元素
 *
 *  给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于?? n/2 ??的元素。
 *
 *  你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  示例?1:
 *
 *  输入: [3,2,3]
 *  输出: 3
 *  示例?2:
 *
 *  输入: [2,2,1,1,1,2,2]
 *  输出: 2
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/majority-element
 *  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  优秀题解：https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 */
public class LeetCode_169_379 {
    public static void main(String[] args) {

    }

    /***
     * 第一种哈希法，使用哈希表存储数字出现次数
     * 执行用时 : 18 ms , 在所有 Java 提交中击败了 33.40% 的用户
     * 内存消耗 : 47 MB , 在所有 Java 提交中击败了 5.10% 的用户
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int num : nums) {
            //存储出现次数
            if(map.get(num)!=null){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }

        //查找出大于n/2，并且次数最多的数字。
        int n=0;
        //出现大于n/2的次数，默认为最小值
        int count=Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer integerCount = map.get(entry.getKey());
            //不仅要看大于n/2，还要出现次数最多的
            //ps：&& integerCount>count  这里其实可以不用考虑：因为是要半数以上，所以不可能出现前面大于半数，后面又大于半数的情况，后面完全不用考虑
            if(integerCount>(nums.length/2) && integerCount>count){
                n=entry.getKey().intValue();
                //记录本次最大次数
                count=integerCount;
            }
        }


        return n;
    }
    /***
     * 第二种哈希法，使用哈希表存储数字出现次数，节省了一层层遍历，但是实际测出来的反而慢了，没搞懂
     * 执行用时 : 22 ms , 在所有 Java 提交中击败了 22.64% 的用户
     * 内存消耗 : 47.3 MB , 在所有 Java 提交中击败了 5.10% 的用户
     */
    public int majorityElement3(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int major=0;
        for (int num : nums) {
            //存储出现次数
            if(map.get(num)!=null){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
            if(map.get(num)>nums.length/2){
                major=num;
                //因为是要半数以上，所以不可能出现前面大于半数，后面又大于半数的情况，后面完全不用考虑
                break;
            }
        }

        return major;
    }

    /***
     * 排序后的众数法：数学中排序好的序列中，n是奇数时，众数的下标为 n/2 ,当 n 是偶数时，下标为 (n/2)+1 ）
     * 其实计算众数位置中 用n/2计算即可
     * 	2 ms	41.8 MB	Java
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
