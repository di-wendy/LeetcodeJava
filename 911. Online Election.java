class TopVotedCandidate {

    TreeMap<Integer, Integer> tmap;
    public TopVotedCandidate(int[] persons, int[] times) {
        tmap = new TreeMap<Integer, Integer>();
        int curWinner = -1;
        int curMaxVote = 0;
        Map<Integer, Integer> map = new HashMap<>();
        tmap = new TreeMap<>();
        for (int i = 0; i < persons.length; ++i){
            int curVote = map.getOrDefault(persons[i], 0) + 1;
            if (curVote >= curMaxVote){
                curWinner = persons[i];
                curMaxVote = curVote;
                tmap.put(times[i], curWinner);
            }
            map.put(persons[i], curVote);
        }
    }
    
    public int q(int t) {
        return tmap.get(tmap.floorKey(t));
    }
}
