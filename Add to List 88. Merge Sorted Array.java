public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int p1 = m - 1;
        int p2 = n - 1;
        int array = m + n - 1;
        
        while(p2>=0 && p1>=0){
            if(nums2[p2] > nums1[p1]){
                nums1[array] = nums2[p2];
                p2 --;
            }
            else{
                nums1[array] = nums1[p1];
                p1 --;
            }
            array --;
        }
        
        if (p2 >= 0){
            for(int i = 0; i <= p2; i++){
                nums1[i] = nums2[i];
            }
        }
        
        return;
    }
}
