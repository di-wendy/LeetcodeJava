class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(0);
        q.offer(temp);
    
        while (!q.isEmpty()){
            //search frontier
            int size = q.size();
            for (int i = 0; i < size; i++){
                List<Integer> cur = q.poll();
                for (int node : graph[cur.get(cur.size() - 1)]){
                    cur.add(node);
                    if (node == graph.length - 1) ans.add(new ArrayList<Integer>(cur));
                    q.offer(new ArrayList<Integer>(cur));
                    cur.remove(cur.size() - 1);
                }
            }
        }

        return ans;
    }
}
