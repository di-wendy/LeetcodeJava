class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<Set<String>> ans = new ArrayList<>();
        Map<String, Integer> Email2Name = new HashMap<>();

        for (int i = 0; i < accounts.length; i++){
            String name = accounts.get(i).get(0);
            String Email = "";
            boolean repeated = false;
            for (int j = 1; j < accounts.get(i).length; j++){
                if(Email2Name.containsKey(accounts.get(i).get(j))){
                    repeated = true;
                    Eamil = accounts.get(i).get(j);
                    break;
                }
            }
            if (repeated){
                int cur = Email2Name.get(Email);
                for (int j = 1; j < accounts.get(i).length; j++){
                    ans.get(cur).add(accounts.get(i).get(j));
                }
            } else {
                ans.add(new HashSet<String());
                ans.get(ans.size() - 1).add(name);
                for (int j = 1; j < accounts.get(i).length; j++){
                    Email2Name.put(accounts.get(i).get(j), ans.size() - 1);
                    ans.get(ans.size() - 1).add(accounts.get(i).get(j));
                }
            }
        }
        List<List<String>> output = new ArrayList<>();
        for (int i = 0; i < ans.length; i++){
            output.add(new ArrayList<>());
            
        }
        
    }
}
