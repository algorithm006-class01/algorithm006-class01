package Alogrithm0308;
//借助leetcode
import java.util.Arrays;

public class Solution621 {
		public int leastInterval(char[] tasks, int n) {
			int[] count = new int[26];
			for (int i = 0; i < tasks.length; i++) {
				count[tasks[i]-'A']++;
			}//统计词频
			Arrays.sort(count);//词频排序，升序排序，count[25]是频率最高的
			int maxCount = 0;
			//统计有多少个频率最高的字母
			for (int i = 25; i >= 0; i--) {
				if(count[i] != count[25]){
					break;
				}
				maxCount++;
			}
			//公式算出的值可能会比数组的长度小，取两者中最大的那个
			return Math.max((count[25] - 1) * (n + 1) + maxCount , tasks.length);
		}
}
