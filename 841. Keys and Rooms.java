class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0)
        search(visited, rooms, 0);
        return visited.size() == rooms.size();
    }
    
    public void search(Set<Integer> visited, List<List<Integer>> rooms, int temp){
        for (int i = 0; i < rooms.get(temp).size(); i++){
            if (!visited.contains(rooms.get(temp).get(i))){
                visited.add(rooms.get(temp).get(i));
                search(visited, rooms, rooms.get(temp).get(i));
            }
        }
    }
}
