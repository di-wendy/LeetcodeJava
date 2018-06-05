class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //Check ans valid
        int total = 0;
        for (int n : nums){
            total += n;
        }
        if (total % k != 0) return false;
        int target = total/k;
        boolean[] visited = new boolean[nums.length];
        return search(nums, 0, target, 0, k, visited);
    }
    
    public boolean search(int[] nums, int index, int target, int curSum, int k, boolean[] visited){
        if (k == 1) return true; //last group sum is doomed to be target
        if (curSum == target) return search(nums, 0, target, 0, k - 1, visited);
        for (int i = index; i < nums.length; i++){
            if (visited[i] == false){
                visited[i] = true;
                if (search(nums, i + 1, target, curSum + nums[i], k, visited)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
