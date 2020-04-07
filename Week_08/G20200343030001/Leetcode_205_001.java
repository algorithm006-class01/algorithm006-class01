package Week_08;

public class Leetcode_205_001 {
    public boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();


        char[] map = new char[300];
        char[] reverseMap = new char[300];

        for(int i=0;i<sChars.length;i++){
            char sCh = sChars[i];
            char tCh = tChars[i];

            if( (map[sCh]==0 || tCh==map[sCh]) && (reverseMap[tCh]==0 || reverseMap[tCh]==sCh) ) {
                map[sCh] = tCh;
                reverseMap[tCh] = sCh;
            }else
                return false;
        }

        for(int i=0;i<sChars.length;i++){
            sChars[i] = map[sChars[i]];
        }

        String newS = new String(sChars);

        return newS.equals(t);
    }
}
