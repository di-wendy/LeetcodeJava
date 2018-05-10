public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums.length == 0) return (new int[0]);
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>(); //store index
        int j = 0;
        
        while( j < n - k + 1){
            for( int i = 0; i < n; i++){
                while(!q.isEmpty() && q.peek() < i - k + 1){
                    q.poll();
                }
                while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                    q.pollLast();
                }
                
                q.offer(i);
                
                if(i >= k - 1){
                    ans[j++] = nums[q.peek()];
                }
            }
        }
        return ans;
    }
}
// Self version
class Solution {
    public void addElement(Deque<Integer> dq, int n){
        while (!dq.isEmpty() && n > dq.peekLast()){
            dq.pollLast();
        }
        dq.offer(n);
    }
    
    public void removeElement(Deque<Integer> dq, int n){
        if (!dq.isEmpty() && dq.peekFirst() == n){
            dq.pollFirst();
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        List<Integer> storeMax = new ArrayList<Integer>();
        Deque<Integer> dq = new ArrayDeque<Integer>();
        //Store the current maximum value
        
        for (int i = 0; i < k - 1; i++){
            addElement(dq, nums[i]);
        }
        
        for (int i = k - 1; i >= 0 && i < nums.length; i++){
            addElement(dq, nums[i]);
            storeMax.add(dq.peekFirst());
            removeElement(dq, nums[i - k + 1]); 
            //remove last elment before the next add
        }
        
        int[] ans = new int[storeMax.size()];
        
        for (int i = 0; i < storeMax.size(); i++){
            ans[i] = storeMax.get(i);
        }
        return ans;
    }
}
