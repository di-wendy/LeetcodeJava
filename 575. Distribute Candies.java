public class Solution {
    public int distributeCandies(int[] candies) {
        
        HashSet<Integer> type = new HashSet<Integer>();
        
        for(int n:candies){
            if(!type.contains(n)){
                type.add(n);
            }
        }
        
        return Math.min(candies.length/2,type.size());
        
    }
}
