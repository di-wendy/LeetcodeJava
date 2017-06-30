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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        ArrayList result = new ArrayList();
        
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> qs = new LinkedList<TreeNode>();
        qs.offer(root);
        
        while(!qs.isEmpty()){
            int size = qs.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < size; i ++){
                TreeNode cur = qs.poll();
                temp.add(cur.val);
                if(cur.left != null){
                    qs.offer(cur.left);
                }
                if(cur.right != null){
                    qs.offer(cur.right);
                }
            }
            result.add(temp);
        }
        
        return result;
    }
}