public class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if((m+n)%2 == 0) {
            return (findkth(nums1, 0, nums2, 0, (m+n)/2) + findkth(nums1, 0, nums2, 0, (m+n)/2 + 1))/2.0;
        }
        return (double)findkth(nums1, 0, nums2, 0, (m+n)/2 + 1);
    }
    
    public int findkth(int[] nums1, int p, int[] nums2, int q, int k) {
        if(p >= nums1.length){
            return nums2[q + k -1];
        } //num1 all gone
        
        if(q >= nums2.length){
            return nums1[p + k -1];
        }
        
        if(k == 1) return Math.min(nums1[p],nums2[q]);
        
        int val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;
        
        //Bound for p + k/2 & q + k/2
        if(p + k/2 - 1 < nums1.length){
            val1 = nums1[p + k/2 - 1];
        }
        if(q + k/2 -1 < nums2.length){
            val2 = nums2[q + k/2 - 1];
        }
        
        if(val1 < val2){
            return findkth(nums1, p + k/2, nums2, q, k - k/2);
        }
        else{
            return findkth(nums1, p, nums2, q + k/2, k - k/2);
        }
    }
}
