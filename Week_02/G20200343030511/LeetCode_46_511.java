class Solution {
    List<List<Integer>> result = new ArrayList<>();	
	public List<List<Integer>> permute(int[] nums) {
		if(nums.length==0||nums ==null) return result;
		List<Integer> list = new ArrayList<>();		
		help(nums,list);		
		return result;
	}
	private void help(int[] nums, List<Integer> list) {
		//判断返回条件,表示所有的选择数都已经选择完毕了
		if(nums.length==list.size()){
			result.add(new ArrayList(list));
			return; 
		}	
		for (int i = 0; i < nums.length; i++) {
			//表示已经选择了。因为不重复。
			if(list.contains(nums[i])) continue;
            list.add(nums[i]);
			help(nums,list);
			//撤销选择
			list.remove(list.size()-1);			
		}		
	}
}