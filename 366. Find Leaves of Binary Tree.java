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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        search(root, ans);
        return ans;
    }
    
    public int search(TreeNode root, List<List<Integer>> ans){
        if (root == null) return 0;
        int left = search(root.left, ans);
        int right = search(root.right, ans);
        int level = Math.max(left, right);
        if (ans.size() <= level) ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        return Math.max(left, right) + 1;
    }
}
