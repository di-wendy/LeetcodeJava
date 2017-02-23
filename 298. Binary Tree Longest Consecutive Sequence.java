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
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root==null) return 0;
        dfs(root,0,root.val);
        return max;
    }
    
    public void dfs(TreeNode root,int num, int target){
        if (root == null) return;
        
        if (root.val == target){
            num += 1;
            max = Math.max(num,max);
        }
        else {
            num = 1;}
            
        dfs(root.left, num, root.val+1);
        dfs(root.right, num, root.val+1);
}
}
