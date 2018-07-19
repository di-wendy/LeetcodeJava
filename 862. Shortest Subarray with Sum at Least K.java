class Solution {
    public int shortestSubarray(int[] A, int K) {
        //Get Presum
        int[] sum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++){
            sum[i + 1] = (i == 0) ? A[i] : sum[i] + A[i];
        }
        Deque<Integer> dq = new LinkedList<>();
        int len = -1;
        int i = 1;
        dq.offerFirst(0);
        while (i < sum.length){
            //Discard all the sum smaller than current sum
            while (!dq.isEmpty() && sum[dq.peekLast()] >= sum[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            while (!dq.isEmpty() && sum[dq.peekLast()] - sum[dq.peekFirst()] >= K){
                if (len == -1) len = dq.peekLast() - dq.peekFirst();
                else len = Math.min(len, dq.peekLast() - dq.peekFirst());
                dq.pollFirst();
            }
            i++;
        }
        return len;
    }
}
