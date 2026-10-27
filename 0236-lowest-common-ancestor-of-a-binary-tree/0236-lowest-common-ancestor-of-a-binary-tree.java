/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode answer=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);
        return answer;
        

        
    }
    public int lca(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return 0 ;
        }
        int left =lca(root.left,p,q);
        int right=lca(root.right,p,q);

        
        int self=0;
        if(root==p||root==q){
            self=1;
        }
        int total = left + right + self; 
        if (total == 2 && answer == null) { 
            answer = root; 
        }
        return total;
    


    }
}