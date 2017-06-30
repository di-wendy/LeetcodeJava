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
    //Iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer> ();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        
        while(root != null){
            ans.add(root.val);
            if(root.right != null){
                rights.push(root.right);
            }
            
            root = root.left;
            
            if(root == null && !rights.isEmpty()){
                root =  rights.pop(); //nearest right
            }
        }
        
        return ans;
    }
}'