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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        return construct(nums, 0, nums.length - 1);
    }
    
    public int getMax(int[] nums, int s, int e){
        int i = s;
        for (int j = s; j <= e; j++){
            if (nums[j] > nums[i]) i = j;
        }
        return i;
    }
    
    public TreeNode construct(int[] nums, int s, int e){
        if (s > e) return null;
        int index = getMax(nums, s, e);
        TreeNode head = new TreeNode(nums[index]);
        head.left = construct(nums, s, index - 1);
        head.right = construct(nums, index + 1, e);
        return head;
    }
}
