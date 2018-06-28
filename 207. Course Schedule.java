class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> q = new LinkedList();
        int count = 0;
        
        for(int i=0;i<numCourses;i++) graph[i] = new ArrayList();
        
        for (int i = 0; i < prerequisites.length; i++){
            degree[prerequisites[i][1]]++; //indegree
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int i = 0; i < degree.length;i++){
            if(degree[i] == 0){
                q.offer(i);
                System.out.print(i);
                count++;
            }
        }
        
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int cur = (int)q.poll();
                for (int n = 0; n < graph[cur].size(); n++){
                    int num = (int)graph[cur].get(n);
                    degree[num]--;
                    if(degree[num] == 0) {
                        q.offer(num);
                        count++;
                    }
                }
            }
        }
        
        return count == numCourses;
    }
}
