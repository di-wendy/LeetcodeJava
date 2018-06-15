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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sumPath(root, 0);
        return total;
    }
    
    public void sumPath(TreeNode root, int sum){
        if (root.left == null && root.right == null) {
            total += (sum * 10 + root.val);
            return;
        }
        if (root.left != null) sumPath(root.left, sum * 10 + root.val); 
        if (root.right != null) sumPath(root.right, sum * 10 + root.val);
    }
}
