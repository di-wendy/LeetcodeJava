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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> st = new ArrayList<>();
        if(root == null) return st;
        if(root.left == null && root.right == null){
            st.add(""+root.val);
        }
        if(root.left != null) dfs(root.left,"" + root.val, st);
        if(root.right != null) dfs(root.right,"" + root.val, st);
        
        return st;
    }
    
    public void dfs(TreeNode root, String s, List<String> set){
        if(root.left == null && root.right == null) {
            set.add(s + "->" + root.val);
            return;}
        
        if(root.left != null) dfs(root.left, s+"->" + root.val, set);
        if(root.right != null) dfs(root.right, s+"->" + root.val, set);
    }
}
