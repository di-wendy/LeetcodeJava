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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return startFromMe(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int startFromMe(TreeNode root, int sum){
        if (root == null) return 0;
        int cur = (root.val == sum) ? 1 : 0;
        return startFromMe(root.left, sum - root.val) + cur + startFromMe(root.right, sum - root.val);
    }
}
