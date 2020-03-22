class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        char[] arr = s.toCharArray();
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int index = 2; index <= s.length(); index ++) {
            if (arr[index - 1] > '0')
                nums[index] = nums[index - 1];
            if ((arr[index - 2] <= '2' && arr[index - 2] > '0') && !(arr[index - 1] > '6' && arr[index - 2] == '2' ))
                nums[index] += nums[index - 2];
        }
        return nums[s.length()];
    }
}