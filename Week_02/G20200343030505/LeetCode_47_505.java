class Solution_47_505 {
	   private List<List<Integer>> result = new ArrayList();
	    public List<List<Integer>> permuteUnique(int[] nums) {

	        if (nums == null || nums.length == 0) {
	            return result;
	        }

	        int depth = 0;
	        LinkedList<Integer> path = new LinkedList<Integer>();
	        boolean[] used = new boolean[nums.length];
	        Arrays.sort(nums);
	        permute(nums, depth, path, used);
	        return result;
	    }

	    public void permute(int[] nums, int depth, LinkedList<Integer> path, boolean[] used) {
	        if (depth == nums.length) {
	            result.add(new ArrayList(path));
	            return;
	        }

	        for (int i=0;i<nums.length;++i) {
	            if (!used[i]) {

	                if (i > 0 && nums[i - 1] == nums[i] && !used[i-1]) {
	                    continue;
	                }

	                used[i] = true;
	                path.addLast(nums[i]);
	                //下一层递归处理
	                permute(nums, depth + 1, path, used);
	                path.removeLast();
	                used[i] = false;
	            }
	        }        
	    }

	}