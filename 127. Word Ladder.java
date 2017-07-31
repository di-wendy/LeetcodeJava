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