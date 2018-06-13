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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        helper(root, "", ans);
        return ans;
    }
    
    public void helper(TreeNode root, String temp, List<String> ans){
        if (root.left == null && root.right == null){
            temp += String.valueOf(root.val);
            ans.add(temp);
            return;
        }
        temp += (String.valueOf(root.val) + "->");
        if (root.left != null) helper(root.left, temp, ans);
        if (root.right != null) helper(root.right, temp, ans);
    }
}
