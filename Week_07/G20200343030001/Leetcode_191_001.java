package Week_07;

public class Leetcode_191_001 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;

        while (n != 0) {
            counter++;
            n &= n - 1;
        }

        return counter;
    }
}
