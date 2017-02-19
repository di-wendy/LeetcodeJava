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
