class AllOne {

    /** Initialize your data structure here. */
    Map<String,Integer> map;
    public AllOne() {
        map = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        map.put(key,map.getOrDefault(key,0)+1);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.isEmpty() || !map.containsKey(key)) return;

        if(map.get(key) == 1 )
            map.remove(key);
        else 
            map.put(key,map.getOrDefault(key,0)-1);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(map.isEmpty()) return "";
        int value = Integer.MIN_VALUE;
        String result = "" ;
        for(var item:map.keySet()){
            if(value < map.get(item)){
                result = item;
                value = map.get(item);
        }
          }  
            return result;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(map.isEmpty()) return "";
        int value = Integer.MAX_VALUE;
        String result ="" ;
        for(var item : map.keySet()){
            if(value > map.get(item)){
                result = item;
                value = map.get(item);
            }
    }
        return result;
}}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */