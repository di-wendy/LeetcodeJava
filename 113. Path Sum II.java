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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),root,sum);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans,List<Integer> temp,
                       TreeNode node, int sum){
        if(node == null) return;
        if(node.left == null && node.right == null && node.val == sum){
            temp.add(node.val);
            ans.add(temp);
            return;
        }
        
        temp.add(node.val);
        helper(ans, new ArrayList(temp), node.left, sum - node.val);
        helper(ans, new ArrayList(temp), node.right, sum - node.val);
    }
}
