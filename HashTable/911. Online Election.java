class TopVotedCandidate {
    TreeMap<Integer, Integer> map= new TreeMap<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        int[] cnt= new int[persons.length];
        int maxCnt=0;
        for (int i=0; i<persons.length; i++){
            int p= persons[i], t= times[i];
            if (++cnt[p]>=maxCnt){
                maxCnt=cnt[p];
                map.put(t, p);
            }
        }
    }
    
    public int q(int t) {
        int time= map.floorKey(t);
        return map.get(time);
    }
}

/*
  0   0   1   1   2
  0  67  69   74  87
*/

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */