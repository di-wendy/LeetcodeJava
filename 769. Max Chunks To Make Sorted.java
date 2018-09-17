class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int j = 0;
        int max = arr[0];
        while (j < arr.length){
            max = Math.max(arr[j], max);
            if (max <= j) {
                count++;
            }
            j++;
        }
        return count;
    }
}
