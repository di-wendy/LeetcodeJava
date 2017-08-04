public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //in order
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = root;
        int count = 0;
        
        while(cur != null || !st.isEmpty()){
            while(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            count++;
            if(count == k){
                return cur.val;
            }
            cur = cur.right;
        }
        
        return 0;
    }
}
