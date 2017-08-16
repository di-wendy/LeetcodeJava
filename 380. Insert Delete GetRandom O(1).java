public class RandomizedSet {
    
    private Map<Integer,Integer> mp;
    private List<Integer> ls;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        mp = new HashMap<Integer,Integer> ();
        ls = new ArrayList<Integer> ();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!mp.containsKey(val)){
            mp.put(val, ls.size());
            ls.add(val);
            return true;
        }else{
            return false;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(mp.containsKey(val)){
            int index = mp.get(val);
            ls.set(index, ls.get(ls.size() - 1));
            mp.put(ls.get(ls.size() - 1), index);
            mp.remove(val);
            ls.remove(ls.size() - 1);
            return true;
        }else{
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return ls.get(Math.abs(r.nextInt())%(ls.size()));
    }
}
