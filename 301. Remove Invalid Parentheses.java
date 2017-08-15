public class Solution {
    public List<String> removeInvalidParentheses(String s) {
           List<String> ans = new ArrayList<>();
            remove(s, ans, 0, 0, new char[]{'(', ')'});
            return ans;
    }
    
    public void remove(String s, List<String> ans, int begin, int end, char[] mark){
        for (int i = begin, stack = 0; i < s.length(); i++){
            if (s.charAt(i) == mark[0]) stack ++;
            if (s.charAt(i) == mark[1]) stack --;
            if (stack >= 0) continue;
            //')'
            for (int j = end; j <= i; j++){
                if (s.charAt(j) == mark[1] && (j == end || s.charAt(j - 1) != mark[1])){
                    remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, mark);
                }
            }
            return; //if not > 0, wont't touch this line
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        if (mark[0] == '('){
            remove(reversed, ans, 0, 0, new char[]{')','('});
        }else{
            ans.add(reversed);
        }
    }
}
