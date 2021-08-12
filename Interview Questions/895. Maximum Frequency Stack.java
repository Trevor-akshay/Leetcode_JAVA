class FreqStack {
    Map<Integer,Integer> freqCount = new HashMap<>();
    Map<Integer,Stack<Integer>> helper = new HashMap<>();
    int maxFreq = 0;
    public FreqStack() {
        
    }
    
    public void push(int val) {
        int freq = freqCount.getOrDefault(val,0) + 1;
        freqCount.put(val,freq);
        if(maxFreq < freq)
            maxFreq = freq;
        helper.computeIfAbsent(freq, a -> new Stack<>()).push(val);
    }
    
    public int pop() {
        int value = helper.get(maxFreq).pop();
        freqCount.put(value,freqCount.get(value) - 1);
        if(helper.get(maxFreq).empty())
            maxFreq--;
        return value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */