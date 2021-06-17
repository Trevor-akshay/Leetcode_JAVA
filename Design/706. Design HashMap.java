class MyHashMap {
class Entry{
        int key;
        int element;
        Entry(int key,int element){
            this.key = key;
            this.element = element;
        }
    }
    /** Initialize your data structure here. */
    List<Entry>[] entries;
    public MyHashMap() {
        entries = new ArrayList[5];

    }

    public void put(int key,int value){
        int index = hashFunction(key);
        if(entries[index] == null){
            entries[index] = new ArrayList<>();
        }
        for(var entry : entries[index]){
            if(entry.key == key){
                entry.element = value;
                return;
            }
        }
        var entry = new Entry(key,value);
        entries[index].add(entry);

    }

    public int get(int key){
        int index = hashFunction(key);
        if(entries[index] != null){
        for(var entry : entries[index]){
            if(entry.key == key)
                return entry.element;
        }
        }
        return -1;
    }
    public void remove(int key){
        int index = hashFunction(key);
        if(entries[index] == null) return;
        entries[index].removeIf(entry -> entry.key == key);
    }
    public int hashFunction(int key){
        return key%entries.length;
}
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */