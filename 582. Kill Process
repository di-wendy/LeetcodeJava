//Stack and DFS
public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        //Unpack Input, map<parent node,<child nodes>>
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++){
            if(!mp.containsKey(ppid.get(i))){
                mp.put(ppid.get(i),new LinkedList<>());
            }
            mp.get(ppid.get(i)).add(pid.get(i));
        }
        
        //From input node, using stack to trace
        List<Integer> ans = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        st.push(kill);
        
        while(!st.isEmpty()){
            int cur = st.pop();
            ans.add(cur);
            List<Integer> temp = mp.get(cur);
            if(temp == null) continue;
            st.addAll(temp);
        }
        return ans;
    }
}
//DFS
