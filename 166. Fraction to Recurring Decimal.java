class Solution {
    public String fractionToDecimal(int ni, int di) {
        if (ni == 0) return "0";
        StringBuilder ans = new StringBuilder();
        //Get Sign
        if ((ni > 0 && di < 0) || (ni < 0 && di > 0)) ans.append("-");
        
        //Get Integer
        long n = Math.abs((long)ni);
        long d = Math.abs((long)di);
        ans.append(n/d);
        n = n % d;
        if (n == 0) return ans.toString();
        
        //Get Decimal
        ans.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        
        //Divided by same d
        map.put(n, ans.length());
        while (n > 0){
            n *= 10;
            ans.append(n/d);
            n %= d;
            if (map.containsKey(n)){
                ans.insert(map.get(n), "(");
                ans.append(")");
                break;
            } else {
                map.put(n, ans.length());
            }
        }
        return ans.toString();
    }
}
