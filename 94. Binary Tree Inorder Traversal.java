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

//Recursion
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        helper(root, ans);
        return ans;
    }
    
    public void helper(TreeNode root, List<Integer> ans){
        if (root == null) return;
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }
}
