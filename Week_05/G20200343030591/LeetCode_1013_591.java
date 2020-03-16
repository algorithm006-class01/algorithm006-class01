class Solution {

    /**
     * 将数组分成和相等的三个部分
     *
     * 思路：
     * 1、先把数据累加起来，看看结果为多少
     * 2、如果 数组 不能 3等份 就返回 false
     * 3、循环累加数组的值，并且每次都计算一下 是否可以 达到3等份以后的sum值
     * 4、能达到 就给 flag++ 表示 当前循环的过程中发现一个 可以三等分的一组数据
     * 5、循环完 只要flag 大于等于3 就表示 可以将数组分成和相等 的3部分
     */
    class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            int sum = 0;
            for (int i : A) {
                sum += i;
            }

            // 不可以分成3份
            if (sum % 3 != 0) {
                return false;
            }

            int s = 0;
            int flag = 0;

            for (int i : A) {
                s += i;
                if (s == sum / 3) {
                    flag++;
                    s = 0;
                }
            }
            return flag >= 3;
        }
    }

}