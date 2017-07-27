public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //iteration DFS
        
        TreeNode cur = root;
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();

        while(cur != null || !st.isEmpty()){
            while(cur != null){
                st.push(cur);
                cur =  cur.left;
            }    
            cur  = st.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        
        return ans;
    }
}