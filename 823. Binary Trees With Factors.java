class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        if (A.length == 0) return 0;
        Arrays.sort(A);
        Map<Integer, Long> map = new HashMap<>();
        for (int n : A) map.put(n, (long)1);
        long ans = A.length;
        for (int i = 0; i < A.length; i++){
            int val = A[i];
            for (int j = 0; j < i; j++){
                if (val%A[j] == 0 && map.containsKey(val/A[j])){
                    long temp = (map.get(A[j]) * map.get(val/A[j]));
                    map.put(val, map.get(val) + temp);
                    ans += temp;
                    ans = ans%((int)(Math.pow(10, 9) + 7));
                }
            }
        }
        return (int)ans;
    }
}
