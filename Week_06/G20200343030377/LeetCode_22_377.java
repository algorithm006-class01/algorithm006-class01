class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("", 0, 0, n);
        return list;
    }
    private void generate(String res, int left, int right, int n){
        if(res.length()==n*2){
            list.add(res);
        }
        if(left<n){
            generate(res+"(", left+1, right, n);
        }
        if(right<left){
            generate(res+")", left, right+1, n);
        }
    }
}
