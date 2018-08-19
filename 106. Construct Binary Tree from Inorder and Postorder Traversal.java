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
    public TreeNode buildTree(int[] in, int[] post) {
        if (in.length != post.length || in.length == 0 || post.length == 0) return null;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < in.length; i++) hm.put(in[i], i);
        return construct(in, 0, in.length - 1, post, 0, post.length - 1, hm);
    }
    
    public TreeNode construct(int[] in, int is, int ie, int[] post, int ps, int pe,
                             Map<Integer, Integer> hm){
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(post[pe]);
        int index = hm.get(post[pe]); //position in inorder
        root.left = construct(in, is, index - 1, post, ps, ps + index - is - 1, hm);
        root.right = construct(in, index + 1, ie, post, pe - (ie - index), pe - 1, hm);
        return root;
    }
}
