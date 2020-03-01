class Solution_77_505 {
	   private List<List<Integer>> result = new ArrayList();
	    public List<List<Integer>> combine(int n, int k) {
	        if (n <= 0 || k <= 0 || n < k) {
	            return result;
	        }

	        LinkedList<Integer> path = new LinkedList<Integer>();
	        combine(n, 0, 1, k, path);
	        return result;
	    }

	    public void combine(int n, int depth, int begin, int k, LinkedList<Integer> path) {
	        if (depth == k) {
	            result.add(new ArrayList(path));
	            return;
	        }

	        for (int i=begin;i<=n-k+path.size()+1;++i) {
	            path.addLast(i);
	            combine(n, depth + 1, i + 1, k, path);
	            path.removeLast();
	        }
	    }
	}