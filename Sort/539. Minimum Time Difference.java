class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> time = new ArrayList<>();
        for(var t : timePoints){
            int hour = Integer.parseInt(t.substring(0,2));
            int min = Integer.parseInt(t.substring(3,5));
            int totalTime = hour * 60 + min;
            time.add(totalTime);
        }
        
        Collections.sort(time);    
        int min = Integer.MAX_VALUE;        
        for(int i = 1;i<time.size();i++)
            min = Math.min(min,time.get(i) - time.get(i-1));
        
        int corner = time.get(0) + (1440 - time.get(time.size()-1));
        
        return Math.min(min,corner);
    }
}