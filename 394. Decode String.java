class Solution {
    public String decodeString(String s) {
        Stack<String> words = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        int i = 0;
        int cur = 0;
        words.push("");
        while (i < s.length()){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                cur = cur * 10 + c - '0';
            } else if (c == '['){
                words.push(""); //KEY
                nums.push(cur);
                cur = 0;
            } else if (c == ']'){
                StringBuilder temp = new StringBuilder();
                int size = nums.pop();
                String sub = words.pop();
                for (int j = 0; j < size; j++){
                    temp.append(sub);
                }
                words.push(words.pop() + temp.toString());
            } else {
                words.push(words.pop() + c);
            }
            i++;
        }
      
        return words.pop();
    }
}
