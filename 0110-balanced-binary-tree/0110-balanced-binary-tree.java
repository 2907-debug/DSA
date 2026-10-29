/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
public boolean isBalanced(TreeNode root) {
int ans = height(root);
return ans != -1;
}

public int height(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int o = height(root.left);
    int t = height(root.right);

    if (o == -1 || t == -1) {
        return -1;
    }

    if (Math.abs(o - t) > 1) {
        return -1;
    }

    return 1 + Math.max(o, t);
}


}
