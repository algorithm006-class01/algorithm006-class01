class Solution {
   public int removeDuplicates(int[] nums) {
		
		if(nums ==null||nums.length==0) return 0;
		if(nums.length==1)return 1;
		
		int i=1,j=1;
		for (; i < nums.length; i++) {
			if(nums[i]!=nums[i-1]){
				nums[j++]=nums[i];
			}			
		}
		
		
		
		return j;
	}
}