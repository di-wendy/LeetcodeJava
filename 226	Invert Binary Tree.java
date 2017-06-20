//DFS
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.right = invertTree(left);
        root.left = invertTree(right);
        
        return root;
    }
}

//BFS
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        Stack <TreeNode> st = new Stack <TreeNode>();
        
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode cur = st.pop();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            
            if(cur.left != null) st.push(cur.left);
            if(cur.right != null) st.push(cur.right);
        }
        
        return root;
    }
}
