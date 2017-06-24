public class Solution {
    public int hIndex(int[] citations) {
        
        if (citations.length == 0) return 0;

        int ans = 0;
        
        for(int i = citations.length - 1; i >=0; i--){
            int temp = Math.min(citations.length - i, citations[i]);
            ans = Math.max(ans,temp);
        }
        
        return ans;
    }
}
//Binary Search
public class Solution {
    public int hIndex(int[] citations) {
        //Binary Search
        int left = 0, right = citations.length - 1, mid;
        
        while(left <= right){
            mid = left + (right - left)/2;
            
            if(citations[mid] >= (citations.length - mid)) {right = mid - 1;}
            else {left = mid + 1;}
        }
        
        return citations.length - left;
    }
}
