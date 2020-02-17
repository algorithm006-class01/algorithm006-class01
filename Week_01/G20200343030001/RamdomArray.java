package Week_01;

/**
 * 测试用随机数组生成器
 *
 * @author wyj
 * @date 2020/2/11
 */
public class RamdomArray {
    public int[] generate(int len, int max) {
        if (len <= 0) {
            return new int[0];
        }

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = (int)(Math.random() * max);
        }

        return arr;
    }
}
