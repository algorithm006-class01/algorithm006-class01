class Solution {
    public void moveZeroes(int[] nums) {
        int i =0;		
		for (; i < nums.length; i++) {
			if(nums[i]==0) break;			
		}
		int j=i;
		for (; j < nums.length; j++) {
			if(nums[j]!=0){
				nums[i]=nums[j];
				i++;
			}
		}
		
		for (int j2 = i; j2 < nums.length; j2++) {
			nums[j2]=0;
		}	
    }
}