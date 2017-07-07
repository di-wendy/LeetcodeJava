//Own Method beat 58%
public class Solution {
    public int strStr(String haystack, String needle) {
        
        int str1 = haystack.length();
        int str2 = needle.length();
        
        if(str2 == 0){
            return 0;
        }
        if(str1 == 0){
            return -1;
        }
        
        //Two pointers
        int i = 0;
        int j = 0;
        
        while(i < str1-str2+1){
            if(haystack.charAt(i) != needle.charAt(0)){
                i++;
                j++;
            }
            else{
                while(j-i <= str2){
                    if(haystack.charAt(j) == needle.charAt(j-i)){
                        j++;
                        
                        if(j-i == str2){
                            return i;
                        }
                    }
                    else{
                        i += 1;
                        j = i;
                        break;
                    }
                }
                
            }
        }
        
        return -1;
    }
}

//Elegant Java
public int strStr(String haystack, String needle) {
  for (int i = 0; ; i++) {
    for (int j = 0; ; j++) {
      if (j == needle.length()) return i;
      if (i + j == haystack.length()) return -1;
      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    }
  }
}
