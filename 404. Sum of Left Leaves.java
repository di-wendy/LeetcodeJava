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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int[] ans = new int[1];
        isLeaf(root, ans);
        return ans[0];
    }
    
    public int isLeaf(TreeNode root, int[] ans){
        if (root.left == null && root.right == null) return root.val;
        int left = 0;
        int right = 0;
        if (root.left != null) left = isLeaf(root.left, ans);
        if (root.right != null) right = isLeaf(root.right, ans);
        if (left != 0) ans[0] += left;
        return 0;
    }
}
