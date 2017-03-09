//String Builder Method
//Append();
//substring(int start, int end)
//deleteCharAt(int index)
//delete(int start, int end)
//append(char[] str)


//33%
public class Solution {
    public String reverseString(String s) {
        
        StringBuilder ans = new StringBuilder();
        
        char[] temp = s.toCharArray();
        
        for(int i=s.length()-1; i>=0; i--){
            ans.append(temp[i]);
        }
        
        return ans.toString();
        
    }
}

//StringBuilder sb = new StringBuilder("MyString");
//String s = sb.toString();

//13%

public class Solution {
    public String reverseString(String s) {
        
        StringBuilder ans = new StringBuilder(s);
        
        ans.reverse();
        
        return ans.toString();
        
    }
}
