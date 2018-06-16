import java.util.*;

class model{

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(k, n, 1, ans, 0, new ArrayList<Integer>());
        return ans;
    }

    public static void helper(int k, int n, int cur, List<List<Integer>> ans, int sum, List<Integer> temp){
        if (temp.size() == k){
            if (n == sum) ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cur; i <= k; i++){
            temp.add(i);
            helper(k, n, i + 1, ans, sum + i, temp);
            temp.remove(temp.size() - 1);
            helper(k, n, i + 1, ans, sum, temp);
        }
    }

    public static void main(String[] args){
        combinationSum3(3, 7);
    }
}