public class Solution {
    public String licenseKeyFormatting(String S, int K) {

    int diff = 'A' - 'a';
    
    String[] strs = S.split("-");
    StringBuilder res = new StringBuilder();
    
    for(int i=0; i<strs.length; i++){
        res.append(strs[i]);
    }
    
    //Capitalize the "a-z"
    for(int i=0; i<res.length(); i++){
        char c = res.charAt(i);
        if (c>='a' && c<='z'){
            res.setCharAt(i,(char)(c+diff));
        }
    }
    
    //Insert backward
    int num = res.length() - K;
    while(num>0){
        res.insert(num,'-');
        num -= K;
    }

    String result = res.toString();
    return result;
}
}
