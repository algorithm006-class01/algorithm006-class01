import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
 * 1244. Design A Leaderboard
 * 力扣排行榜

 */
public class LeetCode_1244_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leaderboard leaderboard = new LeetCode_1244_569().new Leaderboard();
		leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
		leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
		leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
		leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
		leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
		System.out.println(leaderboard.top(1));           // returns 73;
		leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
		leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
		leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
		leaderboard.top(3);           // returns 141 = 51 + 51 + 39;

	}

	class Leaderboard {
		Map<Integer,Integer> playerMap;
		TreeMap<Integer,Integer> scoreMap;

	    public Leaderboard() {
	    	playerMap = new HashMap<Integer,Integer>();
	    	scoreMap = new TreeMap<Integer,Integer>();
	    }
	    
	    public void addScore(int playerId, int score) {
	    	Integer preScore = playerMap.get(playerId);
	    	if(  preScore!= null ) {
	    		Integer count = scoreMap.get(preScore);
	    		if( count <= 1 )
	    			scoreMap.remove(preScore);
	    		else
	    			scoreMap.put(preScore, count-1);
	    		score += preScore;
	    	}
	    	playerMap.put(playerId, score);
	    	scoreMap.put(score, scoreMap.getOrDefault(score,0) + 1);
	    }
	    
	    public int top(int K) {
	    	int sum = 0;
	    	Iterator<Integer> iter = scoreMap.descendingKeySet().iterator();
	    	while( K > 0 && iter.hasNext() ) {
	    		int score = iter.next();
	    		int num = scoreMap.get(score);
	    		sum += Math.min(K, num) * score;
	    		K -= Math.min(K, num);	    		
	    	}
	    	return sum;
	    }
	    
	    public void reset(int playerId) {
	    	Integer score = playerMap.get(playerId);
	    	playerMap.remove(playerId);
	    	if( score != null ) {
	    		Integer count = scoreMap.get(score);
	    		if( count <= 1 )
	    			scoreMap.remove(score);
	    		else
	    			scoreMap.put(score, count-1);
	    	}
	    }
	}

	/**
	 * Your Leaderboard object will be instantiated and called as such:
	 * Leaderboard obj = new Leaderboard();
	 * obj.addScore(playerId,score);
	 * int param_2 = obj.top(K);
	 * obj.reset(playerId);
	 */
}
