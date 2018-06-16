class TwoSum {

    Map<Integer,Integer> hm;
    /** Initialize your data structure here. */
    public TwoSum() {
        hm = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        hm.put(number, hm.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int n : hm.keySet()){
            int target = value - n;
            if (hm.containsKey(target)){
                if (target != n || hm.get(target) > 1) return true;
            }
        }
        return false;
    }
}
