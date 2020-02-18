class Solution {
    List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> combine(int n, int k) {
		if(n==0||k==0) return result;
		List<Integer> list = new ArrayList<>();
		help(n,k,list);		
		return result;
	}

	private void help(int n, int k, List<Integer> list) {
		//ÖÕÖ¹Ìõ¼ş
		if(k==list.size()) {
			result.add(new ArrayList(list));
			return;
		}		
		for (int i = 1; i <= n; i++) {
			if(list.contains(i)) continue;
			list.add(i);
			help(i,k,list);
			list.remove(list.size()-1);
		}		
	}
}