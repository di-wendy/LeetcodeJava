class Solution {
    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) return null;
        int[] shuffles = nums.clone();
        for (int i = shuffles.length - 1; i >= 0; i--){
            int index = rand.nextInt(i + 1); //Exclusive
            int temp = shuffles[i];
            shuffles[i] = shuffles[index];
            shuffles[index] = temp; 
        }
        return shuffles;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
