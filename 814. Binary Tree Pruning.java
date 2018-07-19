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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        int total = prune(root);
        return (total == 0) ? null : root;
    }
    
    
    public int prune(TreeNode root){
        if (root == null) return 0;
        int left = prune(root.left);
        int right = prune(root.right);
        if (left == 0) root.left = null;
        if (right == 0) root.right = null;
        return (left + right + root.val);
    }
}
