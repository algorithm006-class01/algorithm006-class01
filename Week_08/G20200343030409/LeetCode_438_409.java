/*
    time complexity: O(s+p), space complexity: O(p)
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(p.length() > s.length()) return result;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c:p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int left = 0;
        int right = 0;
        int counter = map.size();

        while(right < s.length()) {

            char c = s.charAt(right);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) {
                    counter--;
                }
            }

            right++;
            while(counter == 0) {
                char temp = s.charAt(left);
                if(map.containsKey(temp)) {
                    map.put(temp, map.get(temp)+1);
                    if(map.get(temp) > 0) {
                        counter++;
                    }
                }

                if(right-left == p.length()) {
                    result.add(left);
                }

                left++;
            }

        }
        return result;
    }
}