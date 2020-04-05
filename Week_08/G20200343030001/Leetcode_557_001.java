package Week_08;

public class Leetcode_557_001 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for (String word: words) {
            sb.append(new StringBuilder(word).reverse());
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
