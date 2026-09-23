class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        fun(digits, 0, "", ans);

        return ans;
    }

    void fun(String digits, int idx, String diary, List<String> ans) {

        if (idx == digits.length()) {
            ans.add(diary);
            return;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        char digit = digits.charAt(idx);

        String letters = map[digit - '0'];

        for (int i = 0; i < letters.length(); i++) {

            char ch = letters.charAt(i);

            diary += ch;

            fun(digits, idx + 1, diary, ans);

            diary = diary.substring(0, diary.length() - 1);
        }
    }
}