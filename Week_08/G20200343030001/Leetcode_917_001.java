package Week_08;

public class Leetcode_917_001 {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
                char tmp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = tmp;
            } else if (!Character.isLetter(chars[left])) {
                left++;
            } else {
                right--;
            }
        }

        return String.valueOf(chars);
    }
}
