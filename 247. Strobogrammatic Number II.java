//247. Strobogrammatic Number II
/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

Show Company Tags
Show Tags
Show Similar Problems
*/

public class Solution {
    //Use recursion to solve this problem
    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
    }
    
    public List<String> helper(int n,int m){
        if(n==0){return new ArrayList<String>(Arrays.asList(""));}
        if(n==1){return new ArrayList<String>(Arrays.asList("1","8","0"));}
        
        List<String> temp = helper(n-2,m);
        
        List<String> ans = new ArrayList<String>();
        
        for(int i = 0; i < temp.size(); i++){
            String local = temp.get(i);
            
            if(n != m) {ans.add("0" + local + "0");} //For the perimeter 0s
            ans.add("1" + local + "1");
            ans.add("6" + local + "9");
            ans.add("9" + local + "6");
            ans.add("8" + local + "8");
            
        }
        
        return ans;
    }
}