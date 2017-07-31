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
    public boolean isValidBST(TreeNode root) {
        
        if(root == null) return true;
        
        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        long curval = Long.MIN_VALUE;
        
        while(cur != null || !st.isEmpty()){
            while(cur != null){
                st.push(cur);
                cur =  cur.left;
            }
            cur  = st.pop();
            if(cur.val > curval){
                curval = cur.val;
            }
            else{
                return false;
            }
            cur = cur.right;
        }
        
        return true;
        
    }
}