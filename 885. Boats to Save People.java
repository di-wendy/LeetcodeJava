class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int ans = 0;
        while (i <= j){
            ans++;
            if (people[i] + people[j] <= limit) i++; 
            //被指到的人还没坐船
            j--;
        }
        return ans;
    }
}
