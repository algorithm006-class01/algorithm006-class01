package Week_08;

public class Leetcode_151_001 {
    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].length() != 0) {
                sb.append(str[i]);
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_151_001().reverseWords("  Hello, world!  "));
    }
}
