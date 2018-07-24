class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int diff = 0;
        for (int i = 0; i < A.length - 1; i++){
            for (int j = i + 1; j < A.length; j++){
                if (j == i + 1) diff = A[j] - A[i];
                else if (A[j] - A[j - 1] == diff){
                    count ++;
                } else break;
            }
        }
        return count;
    }
}
