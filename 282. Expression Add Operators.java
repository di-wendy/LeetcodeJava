class Solution {
    
    List<String> ans = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        if(num.length() == 0) return ans;
        helper(num,"",0, 0, target, 0);
        return ans;
    }
    
    public void helper(String num, String temp, int pos, long value, int target, long lastitem){
        if(pos == num.length()){
            if(value == target) ans.add(temp);
            return;
        }
        
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(num, temp + cur, i + 1, cur, target, cur);
            }else{
                helper(num, temp + "+" + cur, i + 1, value + cur, target, cur);
                helper(num, temp + "-" + cur, i + 1, value - cur, target, -cur);
                helper(num, temp + "*" + cur, i + 1, value - lastitem + cur*lastitem, target, cur*lastitem);
            }
        }
        
    }
}
