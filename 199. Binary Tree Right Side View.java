public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root != null) q.offer(root);
        
        while(!q.isEmpty()){
            int k = q.size();
            for(int i = 0; i < k; i++){
                TreeNode temp = q.poll();
                if(i == k - 1){
                    ans.add(temp.val);
                }
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
        }
        
        return ans;
    }
}