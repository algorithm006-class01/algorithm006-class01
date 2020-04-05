package G20200343030375;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_387_375 {
    public int firstUniqChar(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> position = new HashMap<>();
        char[] charArray = s.toCharArray();

        for(int i = 0; i < charArray.length ;i++){
            int j = Integer.valueOf(charArray[i]);

            Integer index = map.get(j);
            if(index == null){
               list.add(1);
               map.put(j,list.size()-1);
                position.put(list.size()-1,i);
            }else{
                list.set(index,list.get(index)+1);
            }

        }
        for(int i=0;i<list.size();i++){
                if(list.get(i)<=1)
                    return position.get(i);
        }
        return -1;

    }

    public static void main(String[] args){
        Leetcode_387_375 solution = new Leetcode_387_375();
        System.out.println(solution.firstUniqChar("dddccdbba"));
    }
}
