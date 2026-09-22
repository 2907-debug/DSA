class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        fun("", 0, 0, n, ans);

        return ans;
    }

    void fun(String diary, int open, int close, int n, List<String> ans) {

        if (open == n && close == n) {
            ans.add(diary);
            return;
        }

        
        if (open < n) {
            fun(diary + "(", open + 1, close, n, ans);
        }

        if (close < open) {
            fun(diary + ")", open, close + 1, n, ans);
        }
    }
}