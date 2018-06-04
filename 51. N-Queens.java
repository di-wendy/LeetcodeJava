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

//Shorter Method
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] res = new int[n];
        search(n, res, 0, ans);
        return ans;
    }
    
    public void search(int n, int[] res, int row, List<List<String>> ans){
        if (n == row){
            ans.add(convert(res));
            return;
        }
        
        for (int i = 0; i < n; i ++){
            res[row] = i; //Will be overwrite, no need to reset
            if (check(res, row)){
                search(n, res, row + 1, ans);
            }
        }
    }
    
    public boolean check(int[] res, int row){
        for (int i = 0; i < row; i++){
            if (res[row] == res[i] ||
               Math.abs(res[row] - res[i]) == row - i){
                return false;
            }
        }
        return true;
    }
    
    public List<String> convert(int[] res){
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < res.length; i++){
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < res.length; j++){
                if (j == res[i]) cur.append('Q');
                else cur.append('.');
            }
            ans.add(cur.toString());
        }
        return ans;
    }
}
