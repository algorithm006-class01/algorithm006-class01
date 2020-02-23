import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class LeetCode_49_423 {

    public static void main(String[] args) {

        String strs[]  = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(strs));

    }

}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
        for(String c :strs) {
            String sort = sortString(c);
            if (hash.containsKey(sort)) {
                hash.get(sort).add(c);
            } else {
                ArrayList t = new ArrayList();
                t.add(c);
                hash.put(sort, t);
            }
        }
        List t = new ArrayList();
        for(List a : hash.values()) {
            t.add(a);
        }
        return t;
    }
    public  static  String sortString(String c) {
        char tempArray[] = c.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}



