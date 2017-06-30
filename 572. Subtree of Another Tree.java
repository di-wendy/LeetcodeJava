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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if(s == null && t==null) return true;
        if(s == null && t!=null) return false;
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(s);
        
        while(!st.isEmpty()){
            TreeNode check = st.pop();
            if(check.val == t.val && isSameTree(check, t)) return true;
            else{
                if(check.left != null) st.push(check.left);
                if(check.right != null) st.push(check.right);
            }
        }
        
        return false;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

//Simplier Method
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}