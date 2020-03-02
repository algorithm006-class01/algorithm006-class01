class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		// 结果集
		List<List<String>> result = new ArrayList<>();
		// 字典中不包含目标单词,先要转换成HashSet，因为数据量大，wordList遍历太慢，超时
		Set<String> wordSet = new HashSet<>(wordList);
		if (!distSet.contains(endWord))
			return result;
		// 放置的每一层的节点
		LinkedList<List<String>> queue = new LinkedList<>();
		// 放置首层节点
		queue.offer(Arrays.asList(beginWord));
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		// 设定是否到可以结束的层次了。
		boolean flag = false;
		while (!queue.isEmpty() && !flag) {
			int size = queue.size();
			Set<String> perVisited = new HashSet<>();
			for (int i = 0; i < size; i++) {
				List<String> tempList = queue.poll();
				// 取list中的最后一个元素，进行判断
				String word = tempList.get(tempList.size() - 1);
				char[] chars = word.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char temp = chars[j];// 保存原始值
					for (char j2 = 'a'; j2 <= 'z'; j2++) {
						if (j2 == temp)
							continue;
						chars[j] = j2;
						// 得到替换后的字符串
						String newString = new String(chars);
						if (!visited.contains(newString) && wordSet.contains(newString)) {
							List<String> newList = new ArrayList<>(tempList);
							newList.add(newString);
							if (newString.equals(endWord)) {
								flag = true;
								result.add(newList);
							}
							perVisited.add(newString);
							queue.offer(newList);
						}
					}
					chars[j] = temp;// 恢复原始值。
				}
			}
			visited.addAll(perVisited);
		}
		return result;
	}
	
	public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		if (wordList == null || wordList.size() == 0)
			return result;		
		// 转换成hash，查找速度快。
		Set<String> words = new HashSet<String>(wordList);
		if(!words.contains(endWord)) return result;
		Set<String> begin = new HashSet<>(), end = new HashSet<>();
		begin.add(beginWord);
		end.add(endWord);
		Map<String, List<String>> treeMap = new HashMap<>();
		boolean front = true;
		boolean flag = buildTreeMap(words, begin, end, treeMap, front);
		if (flag)
			dfs(result, treeMap, beginWord, endWord, new LinkedList<>());
		return result;
	}

	private void dfs(List<List<String>> result, Map<String, List<String>> treeMap, String beginWord, String endWord,
			LinkedList<String> list) {
		list.add(beginWord);
		if (beginWord.equals(endWord)) {
			result.add(new ArrayList<>(list));
			list.removeLast();
			return;
		}
		if (treeMap.containsKey(beginWord)) {
			for (String word : treeMap.get(beginWord)) {
				dfs(result, treeMap, word, endWord, list);
			}
		}
		list.removeLast();
	}
	private boolean buildTreeMap(Set<String> words, Set<String> begin, Set<String> end,
			Map<String, List<String>> treeMap, boolean front) {
		if (begin.size() == 0)
			return true;

		if (begin.size() > end.size())
			return buildTreeMap(words, end, begin, treeMap, !front);

		words.removeAll(begin);
		Set<String> nextLevel = new HashSet<>();
		boolean isMeet = false;
		for (String word : begin) {
			char[] chars = word.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char tmp = chars[i];
				for (char j = 'a'; j <= 'z'; j++) {
					chars[i] = j;
					if (chars[i] == tmp)
						continue;
					String newString = String.valueOf(chars);
					if (words.contains(newString)) {
						nextLevel.add(newString);
						if (end.contains(newString)) {
							isMeet = true;
						}
						String key = front ? word : newString;
						String nextWord = front ? newString : word;
						if (!treeMap.containsKey(key)) {
							treeMap.put(key, new ArrayList<>());
						}
						treeMap.get(key).add(nextWord);
					}
				}
				chars[i] = tmp;
			}
		}
		if (isMeet)
			return true;
		return buildTreeMap(words, nextLevel, end, treeMap, front);
	}
	
}