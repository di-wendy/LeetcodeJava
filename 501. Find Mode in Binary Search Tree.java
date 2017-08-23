/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Integer pre = null;
    int count = 1;
    int max = 1;
    List<Integer> res = new ArrayList<Integer>();
    
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        
        helper(root);
        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    
    public void helper(TreeNode root){
        if (root == null) return;
        helper(root.left);
        if (pre != null){
            if (root.val == pre){
                count ++;
            }
            else{
                count = 1;
            }
        }
        if (count > max){
            res.clear();
            res.add(root.val);
            max = count;
        }
        else if(count == max){
            res.add(root.val);
        }
        pre = root.val;
        helper(root.right);
    }
}
