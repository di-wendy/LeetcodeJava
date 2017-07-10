public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null) return ans;
        q.offer(root);
        
        while(q.size() != 0){
            double sum = 0.0;
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                sum += temp.val;
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            
            ans.add(sum/size);
        }
        
        return ans;
    }
}