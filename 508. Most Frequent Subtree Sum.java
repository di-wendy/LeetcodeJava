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
    Map<Integer, Integer> freq = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Search(root);
        //Put freq into PriorityQueue
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> A, Map.Entry<Integer, Integer> B){
                return (A.getValue() > B.getValue()) ? -1 : 1;
            }
        });
        
        for (Map.Entry<Integer, Integer> element : freq.entrySet()){ //KEY
            q.offer(element);
        }

        int max_freq = q.peek().getValue();
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()){
            Map.Entry<Integer, Integer> cur = q.poll();
            if (cur.getValue() < max_freq) break;
            else ans.add(cur.getKey());
        }
        int[] output = new int[ans.size()];
        for (int i = 0; i < output.length; i++){
            output[i] = ans.get(i);
        }
        return output;
    }
    
    public int Search(TreeNode root){
        if (root == null) return 0;
        int left = Search(root.left);
        int right = Search(root.right);
        int sum = left + right + root.val;
        freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        return sum; //KEY
    }
}
