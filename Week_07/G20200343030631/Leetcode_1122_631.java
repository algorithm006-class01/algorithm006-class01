import java.util.Arrays;

/**
 * 解题思路: 用计数排序思想，对arr1计数统计，排序时对arr1元素，查找在arr2中索引，做插入排序；最后对计数不为0的元素从末尾开始附加
 * 时间复杂度: O(m+n)，m为arr2长度，n为arr1长度
 * 空间复杂度: O(n)，n为arr1长度
 * 执行用时: 0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗: 38.3 MB, 在所有 Java 提交中击败了5.66%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/3/29
 */
public class Version1 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int length = arr1.length;
        int[] result = new int[length];
        int[] counterArray = new int[1001];

        for (int i = 0; i < length; i++) {
            counterArray[arr1[i]]++;
        }

        int relativeIndex = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (counterArray[arr2[i]] != 0) {
                result[relativeIndex++] = arr2[i];
                counterArray[arr2[i]]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (counterArray[i] > 0) {
                result[relativeIndex++] = i;
                counterArray[i]--;
            }
        }
        return result;
    }
}
