class RandomizedSet {

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
