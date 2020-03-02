public class Solution {
    public static void main(String[] args) {
        int[] test1 = new int[]{9, 9, 9, 9};
        int[] test2 = new int[]{4, 3, 2, 1};
        int[] test3 = new int[]{4, 3, 2, 9};
        int[] test4 = new int[]{9,8,7,6,5,4,3,2,1,0};
        List<int[]> ints = new ArrayList<>();
        ints.add(test1);
        ints.add(test2);
        ints.add(test3);
        ints.add(test4);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(plusOne(anInt)));
        }
    }

    /**
     * 解题思路：从数组最后一位倒序处理，0-8直接+1返回，9+1后向前逐步判断，极限情况下如果加至初始位置，则数组长度扩展1
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 执行用时 :1 ms, 在所有 Java 提交中击败了96.78%的用户
     * 内存消耗 :36.2 MB, 在所有 Java 提交中击败了36.51%的用户
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            // 如果当前位不为0，说明无进位，直接返回结果即可
            if (digits[i] != 0){
                return digits;
            }
        }
        // 循环内未返回，说明一直有进位，则复制一个比原数组大1长度的数组
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }
}