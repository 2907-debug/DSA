class Solution {
    public int maxDepth(String s) {

        int depth = 0;      // abhi kitne brackets open hain
        int maxDepth = 0;   // maximum open brackets store karega

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                depth++;

                // opening bracket ke baad maximum check karenge
                maxDepth = Math.max(maxDepth, depth);
            }
            else if (ch == ')') {
                depth--;
            }
        }

        return maxDepth;
    }
}