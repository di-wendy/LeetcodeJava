//
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
    public int getMinimumDifference(TreeNode root) {

        if(root == null) return 0;
        int diff = Integer.MAX_VALUE;
        
        TreeNode cur = root;
        TreeNode last = null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while(cur !=null || !st.isEmpty()){
            while(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if(last == null){
                last = cur;
            }
            else{
                diff = Math.min(diff, cur.val - last.val);
                last = cur;
            }
            cur = cur.right;
        }
        return diff;
    }
}
//
public class Solution {
    
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }
