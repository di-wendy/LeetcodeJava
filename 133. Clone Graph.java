/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> nodes = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map
            = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        // clone nodes    
        nodes.add(node);
        //map.put(node, new UndirectedGraphNode(node.label));
        
        while (!nodes.isEmpty()){
            int size = nodes.size();
            for (int i = 0; i < size; i++){
                UndirectedGraphNode cur = nodes.poll();
                map.put(cur, new UndirectedGraphNode(cur.label));
                for (int j = 0; j < cur.neighbors.size(); j++){
                    if (!map.containsKey(cur.neighbors.get(j))){
                        nodes.offer(cur.neighbors.get(j));
                    }
                }
            }
        }
        
        //Clone side
        for (UndirectedGraphNode cur : map.keySet()) {
            UndirectedGraphNode newNode = map.get(cur);
            for (int j = 0; j < cur.neighbors.size(); j++) {
                newNode.neighbors.add(map.get(cur.neighbors.get(j)));
            }
        }
        return map.get(node);
    }
}
