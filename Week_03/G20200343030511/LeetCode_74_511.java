class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null||matrix.length==0||matrix[0].length==0)
			return false;
		// 判断没有的情况。
		if (matrix[0][0] > target)
			return false;
		if (matrix[matrix.length - 1][matrix[0].length - 1] < target)
			return false;
		int l = 0;
		int r = matrix.length - 1;
		int length = matrix[0].length - 1;
		int mid;
		while (l < r) {
			mid = l + (r - l) / 2;
			if (target >= matrix[mid][0] && target <= matrix[mid][length]) {
				l = mid;
				break;
			} else if (target > matrix[mid][length]) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		// 有的情况，在l层
		int l_l = 0;
		int l_r = length;
		int l_mid;
		while (l_l < l_r) {
			l_mid = l_l + (l_r - l_l) / 2;
			if (target > matrix[l][l_mid]) {
				l_l = l_mid + 1;
			} else {
				l_r = l_mid;
			}
		}

		return l_l == l_r && matrix[l][l_l] == target ? true : false;
	}
}