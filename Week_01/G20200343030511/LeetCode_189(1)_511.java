class Solution {
    public void rotate(int[] nums, int k) {
    	if(nums==null||nums.length<=1) return;
		
		reverise(nums,0,nums.length-1);
		reverise(nums,0,k%nums.length-1);
		reverise(nums,k%nums.length,nums.length-1);
       
    }

	private void reverise(int[] nums, int start, int end) {
		while(start<end){
			int temp =nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
    }
		
}