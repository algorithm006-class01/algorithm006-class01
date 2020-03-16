class Solution {

   public boolean canCross(int[] stones) {
		Map<Integer,Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], new HashSet<Integer>());
		}
		map.get(0).add(0);
		for (int i = 0; i < stones.length; i++) {
			for(int k:map.get(stones[i])){
				int step =k;
				for (int j = step-1; j <= step+1; j++) {
					if(j>0&&map.containsKey(stones[i]+j)){
						map.get(stones[i]+j).add(j);
					}
				}
			}
		}
		return map.get(stones[stones.length-1]).size()>0;
   }
}