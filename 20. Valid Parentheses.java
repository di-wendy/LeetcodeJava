public class Solution {
    public boolean isValid(String s) {
        
        Stack <Character> st = new Stack <Character> ();
        HashMap <Character,Character> hm = new HashMap <Character,Character>();
        hm.put('(',')');
        hm.put('[',']');
        hm.put('{','}');
        
        for(char a:s.toCharArray()){
            if(st.isEmpty()){
                if (!hm.containsKey(a)) return false;
                st.push(a);
                continue;
            }
            if(!hm.containsKey(a)){
                if(st.isEmpty()) return false;
                if(hm.get(st.get(st.size()-1))!=a) return false;
                st.pop();
            }
            else{
                st.push(a);
            }
        }
        
        return st.isEmpty();
    }
}
