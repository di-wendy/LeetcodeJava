public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //Find the min gase point in loop
        int min = Integer.MAX_VALUE;
        int index = -1;
        int total_gas = 0;
        int total_cost = 0;
        
        for (int i = 0; i < gas.length; i++){
            total_gas += gas[i];
            total_cost += cost[i];
            
            if(total_gas - total_cost < min){
                index = i;
                min = (total_gas - total_cost);
            }
        }
        
        return (total_gas >= total_cost)? (index + 1)%gas.length : -1;
    }
}