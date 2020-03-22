/**
 * 思路
 * 1. 获取第 i 位数字。
 * 2. 获取第 i 位数字对应的各个字母 lettersletters。
 * 3. 选择 lettersletters 的第 j 位字母。
 * 4. 进入新的递归。
 * 5. 递归完成，将组合字符串添加进结果集。
 * 6. 撤销 lettersletters 的第 j 位字母。
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<String,String> map = new HashMap<String,String>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        StringBuilder sb = new StringBuilder();
        if (!"".equals(digits)) {
            backtrack(0,result,map,digits,sb);
        }
        return result;
    }

    public void backtrack(int index,List<String> result,Map<String,String> map,String digits,StringBuilder sb) {
        //termination
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        //获取第 i 位数字。
        //获取第 i 位数字对应的各个字母 lettersletters。
        //选择 letters 的第 j 位字母。
        //进入新的递归。
        //递归完成，将组合字符串添加进结果集。
        //撤销 lettersletters 的第 j 位字母。
        //process
        char digit = digits.charAt(index);
        String value = map.get(String.valueOf(digit));
        for (int j = 0; j < value.length(); j++) {
            sb.append(value.charAt(j)); //选择第j个字母
            //drill down
            backtrack(index+1,result,map,digits,sb);
            //reverse state
            sb.deleteCharAt(sb.length()-1);// 撤销第j个字母
        }
       
        

    }
}