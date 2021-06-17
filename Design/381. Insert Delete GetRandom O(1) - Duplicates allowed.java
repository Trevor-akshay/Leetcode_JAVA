class RandomizedCollection {

    /** Initialize your data structure here. */
  
  private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;
    
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) return false;
        
        int idxToRemove = map.get(val).iterator().next();
        map.get(val).remove(idxToRemove);

        int last = list.get(list.size() - 1);
        int lastIdx = list.size() - 1;
        list.set(idxToRemove, last);
        
        map.get(last).add(idxToRemove);
        map.get(last).remove(lastIdx);
        list.remove(lastIdx);
                
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}



/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */