class Node {
    char c;
    int num;
    public Node(char c, int num){
        this.c = c;
        this.num = num;
    }
}

public class Solution {
    public String reorganizeString(String S) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node A, Node B){
                return A.num > B.num ? -1 : 1;
            }
        });
        int[] count = new int[26];
        for (char c : S.toCharArray()) count[c - 'a']++;
        for (int i = 0; i < 26; i++){
            if (count[i] != 0) pq.offer(new Node((char)('a' + i), count[i]));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            Node one = pq.poll();
            sb.append(one.c);
            if (pq.isEmpty()){
                if (one.num == 1) return sb.toString();
                else return "";
            }
            Node two = pq.poll();
            sb.append(two.c);
            if (one.num > 1) pq.offer(new Node(one.c, one.num - 1));
            if (two.num > 1) pq.offer(new Node(two.c, two.num - 1));
        }                       
                        
        return sb.toString();
    }
}
