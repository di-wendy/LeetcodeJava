class Solution {
    public int numFriendRequests(int[] ages) {
        int[] freq = new int[121];
        for (int n : ages) freq[n]++;
        int count = 0;
        for (int i = 1; i <= 120; i++){
            for (int j = 1; j <= 120; j++){
                if (j > 0.5*i + 7 && j <= i){
                    if (i == j) count += freq[i] * (freq[j] - 1);
                    else count += freq[i] * freq[j];
                }
            }
        }
        return count;
    }
}
