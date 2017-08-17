public class Solution {
    public boolean isPowerOfThree(int n) {
		//1162261457 is the maximum 3^x < 2147483647
        return ( n>0 &&  1162261467%n==0);
    }
}