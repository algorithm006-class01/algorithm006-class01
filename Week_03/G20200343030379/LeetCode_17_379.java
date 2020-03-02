package G20200343030379;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *  17. 电话号码的字母组合
 *  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 参考优秀题解：https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8109/My-recursive-solution-using-Java
 */
public class LeetCode_17_379 {
    public static void main(String[] args) {
        List<String> strings = new LeetCode_17_379().letterCombinations("2");
        System.out.println(strings);
    }

    /***
     * 分治法，
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 10.34% 的用户
     * 内存消耗 : 38.1 MB , 在所有 Java 提交中击败了 5.14% 的用户
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits==null || digits.length()==0 ){
            return list;
        }

        //组装Map的电话结构
        Map map=new HashMap();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");


        //递归
        find(list,digits,0,"",map);

        return list;
    }

    private void find(List<String> list, String digits, int level, String str,Map map) {
        //结束标志
        if(level==digits.length()){
            list.add(str);
            return ;
        }

        //执行逻辑
        //一个方格存在多个，需要循环处理
        char[] chars = ((String) map.get(digits.charAt(level)+"")).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //第一种写法，添加后自己删除结尾
            /*str+=(String.valueOf(chars[i]));
            find(list,digits,level+1,str,map);
            //删除手尾工作
            str=str.substring(0,str.length()-1);*/

            //第二种写法，只传递临时变量，不修改本身的值，就不用做收尾工作
            find(list,digits,level+1,str+(String.valueOf(chars[i])),map);
            //删除手尾工作
            //str=str.substring(0,str.length()-1);
        }

    }
}
