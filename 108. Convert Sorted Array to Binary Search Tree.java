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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        TreeNode ans = helper(nums, 0, nums.length - 1);
        return ans;
    }
    
    public TreeNode helper(int[] nums, int lo, int hi){
        if(lo > hi){
            return null;
        }
        TreeNode head = new TreeNode(nums[(lo+hi)/2]);
        head.left = helper(nums, lo, (lo+hi)/2 - 1);
        head.right = helper(nums, (lo+hi)/2 + 1, hi);
        return head;
    }
}