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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1){
            TreeNode ans = new TreeNode(v);
            ans.left = root;
            return ans;
        }
        helper(0, root, v, d);
        return root;
    }
    
    public void helper(int depth, TreeNode root, int v, int d){
        if (depth + 1 == d - 1){ //Key
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(v);
            root.right = new TreeNode(v);
            root.left.left = left;
            root.right.right = right;
            return;
        } else {
            if (root.left != null) helper(depth + 1, root.left, v, d);
            if (root.right != null) helper(depth + 1, root.right, v, d);
        }
    }
}
