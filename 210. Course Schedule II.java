class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] req = new int[numCourses];
        Map<Integer,List<Integer>> mp = new HashMap<>();
        
        for(int[] course:prerequisites){
            if(!mp.containsKey(course[1])){
                mp.put(course[1],new ArrayList<Integer>());
                mp.get(course[1]).add(course[0]);
            }
            else{
                mp.get(course[1]).add(course[0]);
            }
            req[course[0]] ++;
        }
        
        int count = 0;
        int[] res = new int[numCourses];
        Queue<Integer> q = new LinkedList();
        
        for (int i = 0; i < numCourses; i++){
            if(req[i] == 0){
                res[count] = i;
                count ++;
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int course = q.poll();
            if (!mp.containsKey(course)) continue;
            for(int n : mp.get(course)){
                req[n] --;
                if (req[n] == 0){
                    if(count < numCourses){
                        res[count] = n;
                        count ++;
                        q.add(n);
                    }
                }
            }
        }
        
        if(count != numCourses) return new int[0];
        
        return res;
    }
}
