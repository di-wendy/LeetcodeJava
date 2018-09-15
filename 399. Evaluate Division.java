class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++){
            map.computeIfAbsent(equations[i][0], k -> new HashMap<>()).put(equations[i][1], values[i]);
            map.computeIfAbsent(equations[i][1], k -> new HashMap<>()).put(equations[i][0], 1/values[i]);
        }
        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; i++){
            if (!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1])) ans[i] = -1d;
            else if (queries[i][0].equals(queries[i][1])) ans[i] = 1d;
            else {
                ans[i] = dfs(queries[i][0], queries[i][1], map, new HashSet<>(), 1d);
                if (ans[i] != -1){
                    map.get(queries[i][0]).put(queries[i][1], ans[i]);
                    map.get(queries[i][1]).put(queries[i][0], 1d/ans[i]);
                }
            }
        }
        return ans;
    }
    
    public double dfs(String a, String b, Map<String, Map<String, Double>> map, Set<String> visited, double path){
        if (a.equals(b)) return path;
        visited.add(a);
        for (String s : map.get(a).keySet()){
            if (!visited.contains(s)){
                visited.add(s);
                double tempRes = dfs(s, b, map, visited, path * map.get(a).get(s));
                if (tempRes != -1d) return tempRes;
                visited.remove(s);
            }
        }
        return -1d;
    }
}
