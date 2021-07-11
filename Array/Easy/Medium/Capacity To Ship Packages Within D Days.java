class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int min=Integer.MIN_VALUE;
        int max=0;
        
        for(int i=0;i<weights.length;i++){
            min=Math.max(weights[i],min);
            max+=weights[i];
        }
        
        int low=min;
        int high=max;
        
        while(low<=high){
            int mid=(low+high)/2;

            int  days=isPossible(mid,weights,D);

            if(days>D){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    
    
    
    public int isPossible(int mid,int[] weights,int D){
        int count=0;
        int i=0;
        
        while(i<weights.length){
            int sum=0;
            while( i<weights.length && (sum+weights[i])<=mid){
                sum+=weights[i];
                i++;
            }
            count++;     
        }       
        return count;
    }
}