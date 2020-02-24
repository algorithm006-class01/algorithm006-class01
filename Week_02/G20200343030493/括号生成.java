class Solution {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        _generate(0, 0, n, "");
        return null;
    }

    private void _generate(int left, int right, int n, String s) {
        // terminator
        if (level == n && right == n) {
            // filter the invalid s
            result.add(s);
            return;
        }
        // process

        // drill down
        if (left < n)
            _generate(left + 1, right, n, s + "(");
        if (left > right)
            _generate(left, right + 1, n, s + ")");
        // reverse states

    }
}