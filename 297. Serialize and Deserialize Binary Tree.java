/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append('X').append(',');
        }
        else{
            sb.append(root.val).append(',');
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }
        
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> dq = new LinkedList<String>();
        dq.addAll(Arrays.asList(data.split(",")));
        return buildTree(dq);
    }
    
    private TreeNode buildTree(Deque<String> dq){
        String temp = dq.poll();
        if(temp.equals("X")){
            return null;
        }
        else{
            TreeNode ans = new TreeNode(Integer.parseInt(temp));
            ans.left = buildTree(dq);
            ans.right = buildTree(dq);
            return ans;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
