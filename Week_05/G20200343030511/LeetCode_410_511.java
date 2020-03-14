class Solution {
    public int splitArray(int[] nums, int m) {
		
		int l=0,h=0;
		for (int i = 0; i < nums.length; i++) {
			h+=nums[i];
			l = Math.max(l, nums[i]);
		}
		
		while(l<h){
			int mid = l+(h-l)/2;
			int cur =1,sum=0;
			for (int i = 0; i < nums.length; i++) {
				if(sum+nums[i]>mid){
					cur++;
					sum=nums[i];
				}else{
					sum+=nums[i];
				}
			}
			if(cur<=m){
				h=mid;
			}else{
				l=mid+1;
			}		
		}	
		return l;
    }
}