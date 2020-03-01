class Solution {
    public int[] plusOne(int[] digits) {
        int[] arr = digits;
        int idx = arr.length - 1;
        int carry = 1;

        while (idx >= 0) {
            int sum = arr[idx] + carry;
            carry = sum / 10;
            arr[idx] = sum % 10;
            if (carry == 0) {
                break;
            }
            idx--;
        }

        if (carry == 1) {
            int[] result = new int[arr.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = arr[i - 1];
            }

            return result;
        }

        return arr;
        
    }
}
