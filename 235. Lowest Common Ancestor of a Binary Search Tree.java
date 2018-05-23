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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(p.val<root.val && q.val<root.val)
        { return lowestCommonAncestor(root.left,p,q);}
        
         if(p.val>root.val && q.val>root.val)
        { return lowestCommonAncestor(root.right,p,q);}
        
        return root;
        
    }
}
//
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null){
            return root;
        }
        while ((root.val - p.val) * (root.val - q.val) > 0){
            root = p.val < root.val ? root.left : root.right;
        }
        
        return root;
    }
}
