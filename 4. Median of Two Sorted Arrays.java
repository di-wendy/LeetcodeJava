class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 0){
            return ((double)findKth(nums1, nums2, 0, 0, (m + n)/2) + 
                (double)findKth(nums1, nums2, 0, 0, (m + n)/2 + 1))/2.0;
        }
        return (double)findKth(nums1, nums2, 0, 0, (m + n)/2 + 1);
    }
    
    public int findKth(int[] nums1, int[] nums2, int a, int b, int k){
        if (a == nums1.length) return nums2[b + k - 1];
        if (b == nums2.length) return nums1[a + k - 1];
        if (k == 1) return Math.min(nums1[a], nums2[b]);
        
        //第四个element, a, index = 0, b, index = 0, 找第二个
        int valA = (a + k/2 - 1< nums1.length) ? nums1[a + k/2 - 1] : Integer.MAX_VALUE;
        int valB = (b + k/2 - 1< nums2.length) ? nums2[b + k/2 - 1] : Integer.MAX_VALUE;

        if (valA > valB){ //element in B can be removed
            return findKth(nums1, nums2, a, b + k/2, k - k/2);
        } return findKth(nums1, nums2, a + k/2, b, k - k/2);
    }
}
