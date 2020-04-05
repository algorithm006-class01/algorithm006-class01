class Solution {

    /**
     * 暴力法
     * 翻转字符串中的每个单词
     *
     * @param s 字符串 字符串用 空格分隔
     * @return
     */
    public String reverseWords(String s) {
        // 删除 字符串左右两边的空格
        s = s.trim();
        // 使用 分隔split操作 来获取 字符串中的每个数组
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        // 翻转 list列表中的 每个元素（每个字符串）
        Collections.reverse(wordList);
        // 最终list组成的列表
        return String.join(" ", wordList);
    }

    /**
     * 双端队列
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 删除字符串左边的空格
        while (left <= right && s.charAt(left) == ' ') ++left;

        // 删除字符串右边的空格
        while (left <= right && s.charAt(right) == ' ') --right;

        // 初始化一个双端队列
        Deque<String> d = new ArrayDeque();
        StringBuilder word = new StringBuilder();

        // 把字符一个一个的从双端队列的队头 放入队列
        while (left <= right) {
            char c = s.charAt(left);

            if ((word.length() != 0) && (c == ' ')) {
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }


}