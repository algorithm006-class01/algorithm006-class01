List<String> container;
    int n;
    public List<String> generateParenthesis(int n) {
        container = new ArrayList<>();
        this.n = n;
        String str = "";
        helper(0, 0, str);
        return container;
    }

    public void helper(int left, int right, String str) {
        if (left == n && right == n) {
            container.add(str);
        }

        if (left < n) helper(left+1, right, str + "(");
        if (right < left) helper(left, right + 1, str + ")");
    }
