class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(S);
        helper(S, sb, 0, ans);
        return ans;
    }
    
    public void helper(String S, StringBuilder sb, int index, List<String> ans){
        if (index == S.length()){
            ans.add(sb.toString());
            return;
        }
        //某个必取的，用直接循环
        if(!Character.isLetter(S.charAt(index))) helper(S, sb, index + 1, ans);
        else{
            sb.setCharAt(index, Character.toUpperCase(S.charAt(index)));
            helper(S, sb, index + 1, ans);
            sb.setCharAt(index, Character.toLowerCase(S.charAt(index)));
            helper(S, sb, index + 1, ans);
        }
    }
}
