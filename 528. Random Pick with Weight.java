class Solution {
    int[] presum;
    Random rand;
    public Solution(int[] w) {
        presum = new int[w.length];
        if (w.length >= 1) presum[0] = w[0];
        for (int i = 1; i < w.length; i++){
            presum[i] = w[i] + presum[i - 1];
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int k = rand.nextInt(presum[presum.length - 1]);
        //to find the first num greater than k + 1
        int i = 0;
        int j = presum.length - 1;
        while (i < j){
            int mid = (i + j)/2;
            if (presum[mid] > k + 1){
                j = mid;
            } else if (presum[mid] < k + 1){
                i = mid + 1;
            } else  return mid;
        }
        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
