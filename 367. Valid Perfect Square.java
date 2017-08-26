class Solution {
    public boolean isPerfectSquare(int num) {
        long start = 2;
        long end = num;
        
        while (start + 1 < end){
            long mid = start + (end - start)/2;
            long product = mid * mid;
            if (product > num){
                end = mid;
            }
            else if (product < num){
                start = mid;
            }
            else {
                return true;
            }
        }
        
        return (start*start == num || end * end == num);
    }
}
