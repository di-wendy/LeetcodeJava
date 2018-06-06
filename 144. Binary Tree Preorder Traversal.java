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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        
        if (root == null) return ans;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            ans.add(temp.val);
            if(temp.right != null) st.push(temp.right);
            if(temp.left != null) st.push(temp.left);
        }
        
        return ans;
    }
}

//Recursion
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        search(ans, root);
        return ans;
    }
    
    public void search(List<Integer> ans, TreeNode cur){
        if (cur == null) return;
        ans.add(cur.val);
        search(ans, cur.left);
        search(ans, cur.right);
    }
}
