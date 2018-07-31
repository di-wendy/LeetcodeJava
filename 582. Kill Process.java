class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> ans = new ArrayList<>();
        // Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++){
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(kill);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int cur = q.poll();
                ans.add(cur);
                if (map.containsKey(cur)){
                    for (Integer n : map.get(cur)){
                        q.offer(n);
                    }
                }
            }
        }
        return ans;
    }
}

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
