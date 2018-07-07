class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0, 0);
    }
    
    public boolean check(String s, int index, int pre, int post){
        if (index == s.length()) return pre == post;
        if (post > pre) return false;
        if (s.charAt(index) == '(') return check(s, index + 1, pre + 1, post);
        if (s.charAt(index) == ')') return check(s, index + 1, pre, post + 1);
        return check(s, index + 1, pre + 1, post) || check(s, index + 1, pre, post + 1) || check(s, index + 1, pre, post);
    }
}
