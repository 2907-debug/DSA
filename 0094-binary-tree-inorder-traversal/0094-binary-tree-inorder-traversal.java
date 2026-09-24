class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        fun(root, ans);

        return ans;
    }

    void fun(TreeNode node, List<Integer> ans) {

        if (node == null) {
            return;
        }

        fun(node.left, ans);

        ans.add(node.val);

        fun(node.right, ans);
    }
}