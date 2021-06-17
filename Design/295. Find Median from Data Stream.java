class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int left = 0,right = list.size();
        while(left<right){
            int mid = (right+left) / 2;
            if(list.get(mid) > num)
                right = mid;
            else 
                left = mid+1;
        }
        list.add(left,num);
    }
    
    public double findMedian() {
        if(list.size() % 2 != 0)
            return list.get(list.size()/2);
        
       return (list.get(list.size()/2)+list.get(list.size()/2 -1)) * 0.5;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */