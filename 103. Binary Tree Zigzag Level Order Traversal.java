class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root == null) return ans;
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                layer.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            //For even layer, reverse the arrayList
            if (level % 2 == 0) Collections.reverse(layer);
            ans.add(layer);
            level += 1;
        }
        return ans;
    }
}
