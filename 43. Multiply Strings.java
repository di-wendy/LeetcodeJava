public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] ans = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--){
            for (int j =  n - 1; j >= 0; j--){
                int pro = ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                int temp = ans[i + j + 1] + pro;
                
                ans[i + j + 1] = temp % 10;
                ans[i + j] += temp/10;
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (int t : ans){
            if (res.length() != 0 || t != 0){
                res.append(t + "");
            }
        }
        
        return (res.length() == 0)?"0":res.toString();
    }
}
