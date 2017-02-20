public class Solution {
    public String[] findWords(String[] words) {

        List<String> answer = new ArrayList<String>();
        
        Set<Character> h1 = new HashSet<Character>(Arrays.asList('Q','W','E','R','T','Y','U','I','O','P'));
        Set<Character> h2 = new HashSet<Character>(Arrays.asList('A','S','D','F','G','H','J','K','L'));
        Set<Character> h3 = new HashSet<Character>(Arrays.asList('Z','X','C','V','B','N','M'));
        Set<Character> pointer = new HashSet<Character>();
        
        for(String str:words){
            if (str.length()<=1) 
            {answer.add(str);
             continue;}
            String up_str = str.toUpperCase();
            if (h1.contains(up_str.charAt(0))){pointer = h1;}
            if (h2.contains(up_str.charAt(0))){pointer = h2;}
            if (h3.contains(up_str.charAt(0))){pointer = h3;}
            
            boolean in_a_line = true;
            for(int i=1; i<up_str.length(); i++){
                if (!pointer.contains(up_str.charAt(i))) {
                    in_a_line = false;
                    break;
                }
            }
            if(in_a_line){answer.add(str);}
        }
        
        String[] y = answer.toArray(new String[0]);
        return y;
    }
}
