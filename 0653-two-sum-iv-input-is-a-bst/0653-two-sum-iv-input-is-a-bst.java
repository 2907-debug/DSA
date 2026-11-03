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
    public boolean findTarget(TreeNode root, int k) {

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        TreeNode originalRoot = root;


        while (root != null) {
            s1.push(root);
            root = root.left;
        }

        root = originalRoot;

        while (root != null) {
            s2.push(root);
            root = root.right;
        }

       
        while (!s1.isEmpty() && !s2.isEmpty()
                && s1.peek().val < s2.peek().val) {

            int leftVal = s1.peek().val;
            int rightVal = s2.peek().val;

            int sum = leftVal + rightVal;

            if (sum == k) {
                return true;
            }

            else if (sum < k) {
                TreeNode node = s1.pop();
                root = node.right;

                while (root != null) {
                    s1.push(root);
                    root = root.left;
                }
            }

            else {
                TreeNode node = s2.pop();
                root = node.left;

                while (root != null) {
                    s2.push(root);
                    root = root.right;
                }
            }
        }

        return false;
    }
}