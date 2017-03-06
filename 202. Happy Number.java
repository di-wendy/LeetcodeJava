//7.3%
public class Solution {
    public boolean isHappy(int n) {
        
        if(n<0) return false;
        
        Set <Integer> hs = new HashSet <Integer>();
        
        while(!hs.contains(n)){
            hs.add(n);
            n = compute(n);
        }
        
        return (n==1);
    }
    
    public int compute(int n){
        String value = String.valueOf(n);
        int ans = 0;
        for(char t:value.toCharArray()){
            ans += Math.pow(Character.getNumericValue(t),2);
        }
        return ans;
    }
}

//Avoid char munipulation 17.74%
public class Solution {
    public boolean isHappy(int n) {
        
        Set <Integer> hs = new HashSet<Integer>();
        
        int sumval,remain;
        
        while(hs.add(n)){
            sumval = 0;
            while(n > 0){
                remain = n%10;
                sumval += Math.pow(remain,2);
                n /= 10;
            }
            if(sumval==1) return true;
            n = sumval;
        }
        
        return false;
    }
}




//Knowledge Point
//HashSet.add(n) returns 'true'
