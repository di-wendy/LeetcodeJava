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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if (t1 == null && t2 == null) return null;
        
        int v1 = 0;
        int v2 = 0;
        
        if(t1 != null) v1 = t1.val;
        if(t2 != null) v2 = t2.val;

        TreeNode ansnode = new TreeNode(v1 + v2);
        
        if(t1 == null) {
            ansnode.left = mergeTrees(null,t2.left);
            ansnode.right = mergeTrees(null,t2.right);
        }
        else if(t2 == null){
            ansnode.left = mergeTrees(t1.left,null);
            ansnode.right = mergeTrees(t1.right,null);
        }
        
        else{
            ansnode.left = mergeTrees(t1.left,t2.left);
            ansnode.right = mergeTrees(t1.right,t2.right);
        }
        
        return ansnode;
    }

}
