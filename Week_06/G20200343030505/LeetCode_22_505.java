
class LeetCode_22_505 {
   private List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return result;
        }

        String path = "";
        generateParenthesis(n, 0, 0, path);
        return result;
    }

    public void generateParenthesis(int n, int left , int right, String path) {
        if (left == n && right == n) {
            result.add(path);
            return;
        }

        if (left < n) {
            generateParenthesis(n, left + 1, right, path + "(");
        }

        if (left > right) {
            generateParenthesis(n, left, right + 1, path + ")");
        }
    }
}