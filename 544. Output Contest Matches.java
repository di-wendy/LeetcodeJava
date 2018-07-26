class Solution {
    public String findContestMatch(int n) {
        String[] input = new String[n];
        for (int i = 0; i < n; i++) input[i] = Integer.toString(i + 1);
        return fold(input, n);
    }
    
    public String fold(String[] input, int end){
        while (end >= 2){
            for (int i = 0; i < end/2; i++){
                input[i] = "(" + input[i] + "," + input[end - 1 - i] + ")";
            }
            end /= 2;
        }
        return input[0];
    }
}
