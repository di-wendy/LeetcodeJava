 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(0, inorder.length - 1, 0, preorder.length - 1, preorder, inorder);
    }
    
    public TreeNode buildNode(int is, int ie, int ps, int pe, int[] preorder, int[] inorder){
        //pre-order middle -> left -> right //Costruct
        //in-order left -> middle -> right //Divide
        if(ps > pe) return null;
        TreeNode ans = new TreeNode(preorder[ps]);
        
        int i = 0;
        for (i = is; i <= ie; i++){
            if(inorder[i] == preorder[ps]){
                break;
            }
        }
        ans.left = buildNode(is, i - 1, ps + 1, ps + i - is, preorder, inorder);
        ans.right = buildNode(i + 1, ie, pe - (ie - i - 1), pe, preorder, inorder);
        return ans;
    }
}

//
public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
}

public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0; // Index of current root in inorder
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            inIndex = i;
        }
    }
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    return root;
}
