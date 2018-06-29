class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) graph.add(new HashSet<Integer>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> leaves = new HashSet<Integer>();
        for (int i = 0; i < n; ++i)
            if (graph.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            Set<Integer> newLeaves = new HashSet<Integer>();
            for (int k : leaves){
                for (int j : graph.get(k)){
                    graph.get(j).remove(k);
                    if (graph.get(j).size() == 1) newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        if (leaves.size() == 0) leaves.add(0);
        List<Integer> output = new ArrayList<>();
        for (int k : leaves) output.add(k);
        return output;
    }
}
