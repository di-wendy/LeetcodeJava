/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i = 1;
        int j = n;
        
        while (i + 1 < j){
            int mid = i + (j - i)/2;
            if (guess(mid) == 0){
                return mid;
            }
            else if (guess(mid) == -1){
                j = mid;
            }
            else{
                i = mid;
            }
        }
        
        if (guess(i) == 0) return i;
        return j;
    }
}
