class CustomStack {
int[] stack;
    int size;
    int index;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        size = maxSize;
        index=0;
    }

    public void push(int x) {
       if (index<size){
            stack[index++] = x;
        }
    }

    public int pop() {
        if(index == 0) return -1;
        return stack[--index];
    }

    public void increment(int k, int val) {
        if(stack.length == 0) return;
        for(int i = 0;i<k && i<stack.length;i++)
            stack[i] = stack[i] + val;
    }
    }


/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */