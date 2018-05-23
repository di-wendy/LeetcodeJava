class Solution {
    public List<Integer> diffWaysToCompute(String input) {
       List<Integer> res = new LinkedList<>();
       if (input == null || input.length() == 0) return res;

       for (int i = 0; i < input.length(); i++){
           char c = input.charAt(i);
           if (c == '*' || c == '-' || c == '+'){
               List<Integer> left = diffWaysToCompute(input.substring(0, i));
               List<Integer> right = diffWaysToCompute(input.substring(i + 1));
               for (Integer x : left){
                   for (Integer y : right){
                       if (c == '*'){
                           res.add(x * y);
                       }
                       else if (c == '-'){
                           res.add(x - y);
                       }
                       else{
                           res.add(x + y);
                       }
                   }
               }
           }
       }
       if (res.size() == 0) res.add(Integer.valueOf(input));
       return res;
    }
}
