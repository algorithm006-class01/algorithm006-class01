
//用数组先遍历存储每个元素的次数，然后再遍历一遍取第一次为1的
class LeetCode_387_505 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        //初始化一个数组 数组索引即为ascii码值
        int[] arrs = new int[256];
        for (int i=0;i<s.length();++i) {
            arrs[s.charAt(i)]++;
        }

        for (int i=0;i<s.length();++i) {
            if (arrs[s.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;

    }
}