class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        search(ans, S, 0);
        return ans;
    }
    
    public boolean search(List<Integer> temp, String S, int index){
        if (index == S.length() && temp.size() >= 3){
            return true;
        }
        for (int j = index; j < S.length(); j++){
            if (j != index && S.charAt(index) == '0') return false;
            long cur = Long.valueOf(S.substring(index, j + 1));
            if (cur > Integer.MAX_VALUE) return false; //Key
            int size = temp.size();
            if (temp.size() < 2 || cur == (temp.get(size - 1) + temp.get(size - 2))){
                temp.add((int)cur);
                //System.out.println(cur);
                if (search(temp, S, j + 1)) return true;
                temp.remove(temp.size() - 1);
            }
        }
        return false;
    }
}
