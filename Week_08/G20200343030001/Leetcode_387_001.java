package Week_08;

public class Leetcode_387_001 {
    public int firstUniqChar(String s) {
        for(int i = 0; i < s.length(); i++){
            int first = s.indexOf(s.charAt(i));
            int last = s.lastIndexOf(s.charAt(i));

            if(first ==  last){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_387_001().firstUniqChar("jjava"));
    }
}
