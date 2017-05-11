//EASY
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

//Priority Queue
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pg = new PriorityQueue<>();
        
        for(int element:nums){
            pg.offer(element);
            
            if(pg.size() > k){
                pg.poll();
            }
        }
        
        return pg.peek();
    }
}
