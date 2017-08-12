/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            if(knows(ans, i)) //ans is not celebrity, i is possible
                ans = i;
        }
        
        //Check ans
        for(int i = 0; i < n; i++){
            if((ans != i && knows(ans, i)) || (ans!= i && !knows(i, ans))){
                return -1;
            }
        }
        
        return ans;
    }
}
