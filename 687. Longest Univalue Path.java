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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        search(root);
        return ans;
    }
    
    public int search(TreeNode root){
        if (root == null) return 0;
        int left = search(root.left);
        int right = search(root.right);
        if (root.left != null && root.right != null && root.left.val == root.val &&
           root.right.val == root.val){
            ans = Math.max(ans, left + right + 2);
            return Math.max(left, right) + 1;
        }
        if (root.left != null && root.left.val == root.val) {
            ans = Math.max(ans, left + 1);
            return left + 1;
        }
        if (root.right != null && root.right.val == root.val){
            ans = Math.max(ans, right + 1);
            return right + 1;
        }
        return 0;
    }
}
