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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return calSum(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    
    public int calSum(TreeNode root, int sum){
        if(root == null) return 0;
        int add = (root.val == sum)?1:0;
        return calSum(root.left,sum-root.val) + add + calSum(root.right,sum-root.val);
    }
}
