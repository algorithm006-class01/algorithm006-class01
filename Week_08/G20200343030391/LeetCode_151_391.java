package G20200343030391;

public class LeetCode_151_391 {

    public static void main(String[] args) {
        String s = "the sky is blue";
        String reverseWords = new LeetCode_151_391().reverseWords(s);
        System.out.println(reverseWords);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] ss = s.split(" ");
        int n = ss.length;
        StringBuilder ans = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (ss[i].length() == 0) continue;
            ans.append(ss[i]).append(" ");
        }
        int lastIndexOf = ans.lastIndexOf(" ");
        if (lastIndexOf > 0) {
            ans.deleteCharAt(lastIndexOf);

        }
        return ans.toString();
    }
}
