class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans); // Helper function call
        return ans;   
    }


    public void inorder(TreeNode root,List<Integer>ans){
        if(root==null){
            return ;
        }
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}    