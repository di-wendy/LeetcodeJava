public class Solution {
    public int countPrimes(int n) {
        
        int count = 0;
        
        //Default false
        boolean[] store = new boolean[n + 1]; 
        
        for(int i = 2; i < n; i++){
            if(store[i] == false){
                count++;
                for(int j = 2; i*j < n; j++){
                    store[i*j] = true;
                }
            }
        }
        return count;
    }
}