//第一种思路： 先trim去除首尾空格 再从尾部遍历 取出单词往stringBuilder添加 然后输出
//hello world ->  获取到world  再获取到hello stringBuilder=world hello tostring 就是答案
class LeetCode_387_505 {
    public String reverseWords(String s) {
        StringBuilder resultBuilder = new StringBuilder();
        if (s == null || s.length() == 0) {
            return resultBuilder.toString();
        }

        s = s.trim();
        int i = s.length() - 1, j = s.length();//存放要寻找单词的头部和尾部
        while (i > 0) {
            //寻找第一个为空的
            if (s.charAt(i) == ' ') {
                //i+1 到j为本次需要填入的单词
                resultBuilder.append(s.substring(i + 1, j)).append(" ");


                //头尾元素都去空了 要么  "hello"  "hh  dd"  所以i元素需要走到第一个不为空的地方
                //并更新尾部j
                while (s.charAt(i) == ' ') {
                    j = i;
                    --i;                
                }
            }

            
            --i;
        }

        //注意i可能为负，最后还剩一个 单词 0到j
        return resultBuilder.append(s.substring(0, j)).toString();

    }
}