class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] num1 = parse(a);
        int[] num2 = parse(b);
        int real = num1[0] * num2[0] - num1[1] * num2[1];
        int img = num1[0] * num2[1] + num1[1] * num2[0];
        return real + "+" + img + "i";
    }
     //Parse to real and img
    public int[] parse(String s){
        int[] ans = new int[2];
        ans[0] = Integer.valueOf(s.substring(0, s.indexOf('+')));
        ans[1] = Integer.valueOf(s.substring(s.indexOf('+') + 1, s.length() - 1));
        return ans;
    }
}
