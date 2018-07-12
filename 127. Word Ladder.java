class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 1;
        Set<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()){
            if (visited.contains(endWord)) break;
            int size = q.size();
            for (int i = 0; i < size; i++){
                String cur = q.poll();
                for (String s : wordList){
                    if (!visited.contains(s) && distance(s, cur) == 1){
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }
            step++;
       }
       return (visited.contains(endWord)) ? step : 0;
    }
    
    public int distance(String a, String b){
        //a.length() == b.length();
        int count = 0;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }
}
//
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int ans = 1;
        Queue<String> q = new LinkedList<String>();
        Set<String> v = new HashSet<String>();
        Set<String> dic = new HashSet<String>();
        
        for(String w:wordList){
            dic.add(w);
        }
        
        q.offer(beginWord);
        
        while(!q.isEmpty()){
            
            int k = q.size();
            for(int h = 0; h < k; h++){
                String temp = q.poll();
                for(int i = 0; i < temp.length(); i++){
                    for(char j = 'a'; j <= 'z'; j++){
                        char[] chars = temp.toCharArray();
                        chars[i] = j;
                        String reb = new String(chars);
                        if(!v.contains(reb) && dic.contains(reb)){
                            if(reb.equals(endWord)) return ans + 1;
                            v.add(reb);
                            q.offer(reb);
                        }
                    }
                }
            }
            ans++;
        }
        
        return 0;
    }
}
