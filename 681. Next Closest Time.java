class Solution {
    int diff = Integer.MAX_VALUE;
    String ans = "";
    
    public String nextClosestTime(String input) {
        input = input.replaceAll(":","");
        helper(input, "");
        return ans.substring(0,2) + ":" +ans.substring(2);
    }

    public void helper(String input, String temp){
        if (temp.length() == input.length()){
            if (Integer.valueOf(temp.substring(0,2)) <= 24 && Integer.valueOf(temp.substring(2)) <= 59) {
                int cur = calDiff(temp, input) > 0 ? calDiff(temp, input) : calDiff(temp, input) + 24 * 60;
                if (diff > cur) {
                    diff = cur;
                    ans = temp;
                }
            }
            return;
        }
        for (int i = 0; i < input.length(); i++){
            String newTemp = temp + input.substring(i, i+1);
            helper(input, newTemp);
        }
    }

    public int calDiff(String a, String b){
        int A = (a.charAt(0) * 10 + a.charAt(1))*60 + a.charAt(2) * 10 + a.charAt(3);
        int B = (b.charAt(0) * 10 + b.charAt(1))*60 + b.charAt(2) * 10 + b.charAt(3);
        return A-B;
    }
}
