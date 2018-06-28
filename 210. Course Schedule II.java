class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //拓扑排序，关系表示依赖
        List[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> q = new LinkedList();
        List<Integer> courses = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++) graph[i] = new ArrayList<Integer>();
        
        for (int i = 0; i < prerequisites.length; i++){
            degree[prerequisites[i][1]]++; //outDegree
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int i = 0; i < degree.length;i++){
            if(degree[i] == 0){
                q.offer(i);
                courses.add(i);
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
                        courses.add(num);
                    }
                }
            }
        }
        if (courses.size() < numCourses) return new int[0];
        int[] ans = new int[courses.size()];
        for (int i = courses.size() - 1; i >= 0; i--){
            ans[courses.size() - 1 - i] = courses.get(i);
        }
        return ans;
    }
}
