class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		// visited修改为boolean数组
		boolean[] visited = new boolean[wordList.size()];
		int idx = wordList.indexOf(beginWord);
		if (idx != -1) {
			visited[idx] = true;
		}
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int count = 0;
		while (queue.size() > 0) {
			count++;
			int len=queue.size();
			for (int j = 0; j < len; j++) {
				String word = queue.poll();
				for (int i = 0; i < wordList.size(); i++) {
					if (word.equals(endWord)) 
						return count;
					if (!visited[i]&&isValid(word, wordList.get(i))) {
						queue.offer(wordList.get(i));
						visited[i] = true;
					}
				}
			}
		}
		return 0;
	}

	boolean isValid(String word1, String word2) {
		char[] word1char = word1.toCharArray();
		char[] word2char = word2.toCharArray();
		int count = 0;
		for (int i = 0; i < word2char.length; i++) {
			if (word1char[i] != word2char[i]) {
				count++;
			}
		}
		if (count == 1)
			return true;
		return false;
	}
}