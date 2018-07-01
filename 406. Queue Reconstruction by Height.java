class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //Height from tall to short
        //number from min to max
        List<int[]> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] A, int[] B){
                if (A[0] > B[0]) return -1;
                else if (A[0] < B[0]) return 1;
                else return (A[1] < B[1]) ? -1 : 1;
            }
        });
        
        for (int[] p : people) pq.offer(p);
        
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            ans.add(cur[1], cur);
        }
        int[][] output = new int[people.length][2];
        for (int i = 0; i < people.length; i++){
            int[] temp = ans.get(i);
            output[i][0] = temp[0];
            output[i][1] = temp[1];
        }
        return output;
    }
}
