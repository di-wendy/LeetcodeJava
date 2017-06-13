public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int total = 0;
        int i = 0;
        
        while(i < flowerbed.length){
            if(flowerbed[i] == 1){
                i+=2;
                continue;}
            if((i==0 || flowerbed[i-1] == 0) && (i==flowerbed.length-1 ||flowerbed[i+1] == 0)){
                flowerbed[i] = 1;
                i +=2;
                total += 1;
                continue;
            }
            i += 1;
        }
        
        return (n <= total);
    }
}
