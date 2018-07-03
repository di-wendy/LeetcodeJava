//Update
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        search(ans, "", 0, 0, n);
        return ans;
    }
    
    public void search(List<String> ans, String temp, int pre, int post, int n){
        if (post > pre) return;
        if (temp.length() == 2*n) {
            if (pre == post) ans.add(temp);
            return;
        }
        search(ans, temp + "(", pre + 1, post, n);
        search(ans, temp + ")", pre, post + 1, n);
    }
}
//
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        dfs(list,"",n,n);
        return list;
        
    }
    
    public void dfs(List<String> list,String str, int left, int right){
        
        //left is number of "("
        //right is number of ")"
        if(left>right){
            return; //being pruned
        }
        
        if(left > 0){
            dfs(list,str+"(",left-1,right);
        }
        
        if(right>0){
            dfs(list,str+")",left,right-1);
        }
        
        if(left==0 && right==0){
            list.add(str);
            return;
        }
    }
}
