/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int rob(TreeNode root) {
        
        if(root == null) return 0;
        return Math.max(include(root),exclude(root));
    }
    
    public int include(TreeNode root){
        if(root == null) return 0;
        return root.val + exclude(root.left) + exclude(root.right);
    }
    
    public int exclude(TreeNode root){
        if(root == null) return 0;
        return rob(root.left) + rob(root.right);
    }
    
}
