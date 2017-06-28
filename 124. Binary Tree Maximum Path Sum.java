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
    int ans = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right),0);
        
        ans = Math.max(ans,left + right + root.val);
        
        return root.val + Math.max(left,right);
    }
  }
  
  //Divide and Conquer
  public class Solution {
    
    //Divide and Conquer, Space O(h) recursive stack
    
    private class ResultType{
        int singlePath, maxPath;
        ResultType(int a, int b){
                this.singlePath = a;
                this.maxPath = b;
        }
    }

    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0, Integer.MIN_VALUE);
        }
        
        //Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        //Conquer
        int single = Math.max(0, Math.max(left.singlePath, right.singlePath) + root.val);
        int max = Math.max(left.singlePath + right.singlePath + root.val, Math.max(left.singlePath, right.singlePath));
        
        return new ResultType(single, max);
        
    }
    
    public int maxPathSum(TreeNode root) {
        ResultType ans = helper(root);
        return ans.maxPath;
        
    }
}
