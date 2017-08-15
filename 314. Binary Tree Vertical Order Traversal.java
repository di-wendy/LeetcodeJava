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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        //in order tranverse
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> col = new LinkedList<Integer>();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        q.add(root);
        col.add(0);
        int mark1 = 0;
        int mark2 = 0;
        
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode temp = q.poll();
                int cur = col.poll();
                if(!mp.containsKey(cur)){
                    mp.put(cur, new ArrayList<Integer>());
                }
                mp.get(cur).add(temp.val);
                if(temp.left != null){
                    q.add(temp.left);
                    col.add(cur - 1);
                    mark1 = Math.min(mark1, cur - 1);
                }
                if(temp.right != null){
                    q.add(temp.right);
                    col.add(cur + 1);
                    mark2 = Math.max(mark2, cur + 1);
                }
            }
        }
        
        for(int i = mark1; i <= mark2; i++){
            ans.add(mp.get(i));
        }
        
        
        return ans;
        
    }
}
