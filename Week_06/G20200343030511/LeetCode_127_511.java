class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		// visited修改为boolean数组
		boolean[] leftVisited = new boolean[wordList.size()];
		int idx = wordList.indexOf(beginWord);
		if (idx != -1) {
			leftVisited[idx] = true;
		}
		Queue<String> leftQueue = new LinkedList<>();
		leftQueue.offer(beginWord);
		int leftCount = 0;

		Queue<String> rightQueue = new LinkedList<>();
		rightQueue.offer(endWord);
		int rightCount = 0;

		boolean[] rightVisited = new boolean[wordList.size()];
		int end = wordList.indexOf(endWord);
		if (end == -1) {
			return 0;
		}
		rightVisited[end] = true;
		while (leftQueue.size() > 0 && rightQueue.size() > 0) {
			leftCount++;
			if(leftQueue.size()>rightQueue.size()){
				Queue<String> tmp =leftQueue;
				leftQueue = rightQueue;
				rightQueue =tmp;
				boolean[] t = leftVisited;
				leftVisited =rightVisited;
				rightVisited =t;
				
			}		
			int leftSize = leftQueue.size();
			for (int i = 0; i < leftSize; i++) {
				String leftWord = leftQueue.poll();
				for (int j = 0; j < wordList.size(); j++) {
					if (leftVisited[j])
						continue;

					if (!isValid(leftWord, wordList.get(j))) {
						continue;
					}
					if (rightVisited[j]) {
						return leftCount + 1;
					}
					leftQueue.offer(wordList.get(j));
					leftVisited[j] = true;
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