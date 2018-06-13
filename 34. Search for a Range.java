class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1, -1};
        
        if (A.length <= 0) return res;
        int i = 0, j = A.length - 1;
        // Search for the left one
        while (i < j){
            int mid = i + (j - i)/2;
            if (A[mid] < target) i = mid + 1;
            else j = mid;
        }
        if (A[i] != target) return res;
        else res[0] = i;

        // Search for the right one
        j = A.length - 1;
        while (i < j) {
            int mid = i + (j - i)/2 + 1;
            if (A[mid] > target) j = mid - 1;
            else i = mid;
        }
        res[1] = j;
        return res;
    }
}
