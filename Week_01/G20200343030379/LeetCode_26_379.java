package G20200343030379;

/**
 * @ClassName:
 * @Description: TODO
 * @author ban
 * @date
 *
 */
public class LeetCode_26_379 {
    public int removeDuplicates(int[] nums) {
        int head=0;
        int tail=1;
        int count=1;
        if(nums.length==0) return 0;
        // if(nums.length>1){
        //     head=0;
        //     tail=1;
        // }else{
        //     //只有一个原样返回
        //     return count;
        // }
        int c=0;
        for(;tail<nums.length;){
            //System.out.print("达到");

            //相同则移动tail
            if(nums[head]==nums[tail]){
                tail++;
            }

            //边界处理
            if(tail>nums.length-1){
                return count;
            }

            //不同的则移动head，并交换
            if(nums[head]!=nums[tail]){  //System.out.print("哈哈");
                head++;
                nums[head]=nums[tail];
                count++;
                tail++;
            }
            //c++;
        }
        //System.out.print("哈哈");
        //System.out.print(c);
        return count;
    }
}
