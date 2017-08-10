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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }
    
    public String postorder(TreeNode cur, Map<String,Integer> set, List<TreeNode> res){
        if(cur == null) return "#";
        String serial = cur.val + "," + postorder(cur.left, set, res) + "," + postorder(cur.right, set, res);
        
        if (set.containsKey(serial)){
            if(set.get(serial) == 1) res.add(cur);
            set.put(serial, set.get(serial) + 1);
        } 
        else{
            set.put(serial, 1);
        }
        return serial;
    }
}
