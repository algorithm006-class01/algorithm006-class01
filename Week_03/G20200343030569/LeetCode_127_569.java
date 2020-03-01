import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 127. Word Ladder
 * 单词接龙
 */
public class LeetCode_127_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		wordList.add("hog");
		wordList.add("hig");
		LeetCode_127_569 main = new LeetCode_127_569();
		int result = main.new Solution().ladderLength(beginWord, endWord, wordList);
		System.out.println( result );

	}

	class Solution {
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	    	if (!wordList.contains(endWord)) {
	            return 0;
	        }
	        boolean[] visited = new boolean[wordList.size()];
	        int idx = wordList.indexOf(beginWord);
	        if (idx != -1) {
	            visited[idx] = true;
	        }
	        List<String> levelNodes = new LinkedList<String>();
	        levelNodes.add(beginWord);
	        int level = 0;
	        while( levelNodes.size() > 0 ) {
		        List<String> nextLevelNodes = new LinkedList<String>();
		        level++;
		        for( String node : levelNodes ) {
		        	
		        	for (int i = 0; i < wordList.size(); ++i) {
		                if (visited[i]) {
		                	continue;
		                }
		                String s = wordList.get(i);
		                if (!canConvert(node, s)) {
		                	continue;
		                }
		                if (s.equals(endWord)) {
		                	return level + 1;
		                }
		                visited[i] = true;
		                nextLevelNodes.add(s);
		        	}
		        }
		        levelNodes = nextLevelNodes;
	        }
	        return 0;
	    }
	    
	    public boolean canConvert(String s1, String s2) {
	        int count = 0;
	        for (int i = 0; i < s1.length(); ++i) {
	            if (s1.charAt(i) != s2.charAt(i)) {
	                ++count;
	                if (count > 1) {
	                    return false;
	                }
	            }
	        }
	        return count == 1;
	    }

	}
}
