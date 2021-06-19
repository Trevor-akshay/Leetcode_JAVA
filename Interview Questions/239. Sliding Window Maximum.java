class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      //if(nums==null||nums.length==0 ) 
           // return new int[0];
        
        Deque<Integer> queue = new ArrayDeque<>();
    
        int[] ans = new int[nums.length-k+1];
        int ians=0;
        
        for(int i=0;i<nums.length;i++){
        
            if(!queue.isEmpty() && queue.peek() < i-k+1){
                queue.poll();
            }    
            
           while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]){
                queue.pollLast();
            }
            
            queue.offer(i);
            
            if(i>= k-1){ 
                ans[ians++] = nums[queue.peek()];
            }
        }
        
        return ans;
    }
    }
