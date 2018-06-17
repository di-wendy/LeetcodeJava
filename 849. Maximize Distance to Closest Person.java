class Solution {
    public int maxDistToClosest(int[] seats) {
        int i = 0;
        int j = 0;
        int diff = 0;
        while (i < seats.length){
            if (seats[i] == 1){
                if (j == 0 && seats[j] == 0) diff = Math.max(diff, (i - j));
                else diff = Math.max(diff, (i - j)/2);
                j = i;
            }
            i++;
        }
        if (seats[seats.length - 1] == 0) diff = Math.max(seats.length - j - 1, diff);
        return diff;
    }
}
