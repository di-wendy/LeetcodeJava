public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n<=0) return ans;
        dfs(ans, new ArrayList<Integer>(), n);
        return ans;
    }
    
    public void dfs(List<List<String>> ans, List<Integer> temp, int n){
        //temp store the row occupation, if row1 col n
        if(temp.size() == n){
            ans.add(output(temp));
        }
        
        for(int i = 0; i < n; i++){
            if(!checkattack(temp, i)){
                continue;
            }
            temp.add(i);
            dfs(ans, temp, n);
            temp.remove(temp.size() - 1);
        }
    }
    
    public boolean checkattack(List<Integer> temp, int col){
    //true if attack success
        for(int i = 0; i < temp.size(); i++){
            int excol = temp.get(i);
            if(col == excol){
                return false;
            }
            else if (col + temp.size() == excol + i){
                return false;
            }
            else if (col - excol == temp.size() - i){
                return false;
            }
        }
        return true;
    }
    
    public List<String> output(List<Integer> res){
        //convert [1,2,3] into checkerboard
        List<String> ans = new ArrayList<String>();
        for(int row = 0; row < res.size(); row++){
            StringBuilder sb = new StringBuilder();
            for(int col = 0; col < res.size(); col++){
                sb.append((res.get(row)==col)?'Q':'.');
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
