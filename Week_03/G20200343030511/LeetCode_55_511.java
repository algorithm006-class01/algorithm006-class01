class Solution {
    enum Index {
	    GOOD, BAD, UNKNOWN
	}
    public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		Index[] mem = new Index[nums.length];
		for (int i = 0; i < nums.length; i++) {
			mem[i]=Index.UNKNOWN;
		}
		mem[nums.length-1]=Index.GOOD;
		boolean flag = dfs1(nums,0,mem);
    	return flag;
	}

	private boolean dfs1(int[] nums, int i,Index[] mem) {
		if (mem[i] != Index.UNKNOWN) {
            return mem[i] == Index.GOOD ? true : false;
        }
		int foot = Math.min(nums[i]+i,nums.length-1);
		for (int j = i+1; j <=foot; j++) {	
			if(dfs1(nums,j,mem)){
				mem[i]=Index.GOOD;
				return true;
			}			
		}		
		mem[i]=Index.BAD;
		return false;
	}			
}