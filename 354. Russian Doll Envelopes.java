class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //sort by width, min -> max
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] A, int[] B){
                if (B[0] - A[0] != 0){
                    return B[0] - A[0];
                }
                else {
                    return A[1] - B[1];
                }
            }
        });
        
        int[][] tails = new int[envelopes.length][2];
        int size = 0;
        int width = 0;
        for (int i = 0; i < envelopes.length; i++){
            int left = 0, right = size;
            int cur = envelopes[i][1];
            
            while (left != right){
                int mid = (left + right) / 2;
                if (tails[mid][1] > envelopes[i][1] && tails[mid][0] > envelopes[i][0]){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            tails[left][0] = envelopes[i][0];
            tails[left][1] = envelopes[i][1];
            
            if (left == size) size++;
        }
        
        return size;
    }
}
