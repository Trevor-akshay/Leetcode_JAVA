class RandomizedSet {

    /** Initialize your data structure here. */
   Random random;
Set<Integer>  set;

public RandomizedSet() {
    set=new HashSet<>();
    random=new Random();
}

public boolean insert(int val) {
    return !set.contains(val)?set.add(val):false;
}

public boolean remove(int val) {
    return set.contains(val)?set.remove(val):false;
}

public int getRandom() {
    int random_val=random.nextInt(set.size());
    int current=0;
    for(int i: set){
        if(current==random_val) return i;
        current++;
    }
    return 0;
}}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */