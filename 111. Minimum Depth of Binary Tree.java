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
    int level = Integer.MAX_VALUE;
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        search(root, 1);
        return level;
    }
    
    public void search(TreeNode root, int depth){
        if (root.left == null && root.right == null){
            level = Math.min(level, depth);
            return;
        }
        if (root.left != null) search(root.left, depth + 1);
        if (root.right != null) search(root.right, depth + 1);
    }
}
//Easier Method
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
