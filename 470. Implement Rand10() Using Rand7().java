class Solution extends SolBase {
    public int rand10() {
        int temp = (rand7() - 1) * 7 + rand7();
        while (temp > 40){
            temp = (rand7() - 1) * 7 + rand7();
        }
        return 1 + temp%10;
    }
}
