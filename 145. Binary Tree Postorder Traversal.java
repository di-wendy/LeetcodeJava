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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        LinkedList<Integer> ans = new LinkedList<Integer>();
        TreeNode cur = root;
        
        while(cur != null || !st.isEmpty()){
            if(cur != null){
                st.push(cur);
                ans.addFirst(cur.val);
                cur = cur.right;
            }
            else{
                TreeNode temp = st.pop();
                cur = temp.left;
            }
        }
        
        return ans;
    }
}
