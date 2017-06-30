/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> st = new Stack<TreeNode>();
    private TreeNode cur;
    
    public BSTIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ( cur != null || !st.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        //Guarantee pop non null
        while(cur != null){
            st.add(cur);
            cur = cur.left;
        }
        
        cur = st.pop();
        TreeNode node = cur;
        cur = cur.right;
        
        return node.val;
    }
}