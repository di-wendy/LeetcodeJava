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
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if(root == null) return;
        TreeNode dummy = new TreeNode(0);
        st.push(root);
        TreeNode cur = dummy;
        
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            cur.right = temp;
            cur.left = null;
            if (temp.right != null) st.push(temp.right);
            if (temp.left != null) st.push(temp.left);
            cur = temp;
        }
    }
}
