public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        if(start.length() != end.length()) return -1;
        
        int count = 0;
        char[] bucket = new char[]{'A','C','T','G'};
        
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        Set<String> banks = new HashSet<String>();
        
        for(String s: bank)
            banks.add(s);
        
        q.offer(start);
        visited.add(start);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                for(int j = 0; j < cur.length(); j++){
                    for(char c:bucket){
                        StringBuilder temp = new StringBuilder(cur);
                        if(c != cur.charAt(j))
                            temp.setCharAt(j,c);
                         else
                            continue;
                        String str = temp.toString();
                        if(!visited.contains(str) && banks.contains(str)){
                            if(str.equals(end)) return count + 1;
                            visited.add(str);
                            q.offer(str);
                        }
                    }
                }
            }
            count += 1;
        }
        return -1;   
    }
}