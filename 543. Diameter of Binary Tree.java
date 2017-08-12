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
    
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return max;
    }
    
    public int findMax(TreeNode root){
        if(root == null) return 0;
        
        int left = findMax(root.left);
        int right = findMax(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
    
}
