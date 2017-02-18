public class Solution {
    public List<String> readBinaryWatch(int num) {
        
        List<String> answer = new ArrayList<String>();
        
        if (num>10) return answer;
        
        for (int h=0; h<=11; h++){
            for (int m=0; m<=59; m++){
                int a = Integer.bitCount(h);
                int b = Integer.bitCount(m);
                if ((a+b)==num){
                    answer.add(String.format("%s:%02d",h,m));
                }
            }
        }
        return answer;
    }
}
