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
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        String res = "";
        
        if (left == "" && right == "") res = t.val + "";
        if (left == "" && right != "") res = t.val + "()(" + right + ")";
        if (left != "" && right == "") res = t.val + "(" + left + ")";
        if (left != "" && right != "") res = t.val + "(" + left +")(" + right + ")";
        
        return res;
    }
}