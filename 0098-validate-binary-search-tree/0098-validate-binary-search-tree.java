class Solution {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (prev != null && root.val <= prev.val) {
            return false;
        }

        prev = root;

        if (!isValidBST(root.right)) {
            return false;
        }

        return true;
    }
}
        