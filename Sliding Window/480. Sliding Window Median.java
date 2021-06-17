class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] median = new double[nums.length-k+1];
        int left = 0,right= 0;
        int index = 0;
        if(k % 2 ==0){
            List<Double> temp = new ArrayList<>();
            for(;right<k;right++)
                temp.add((double) nums[right]);
            Collections.sort(temp);
            double sum = temp.get((temp.size()/2)-1)+temp.get(temp.size()/2);
            median[index++] = sum/2;
            for(;right<nums.length;right++){
                temp.remove((double) nums[left++]);
                temp.add((double)nums[right]);
                Collections.sort(temp);
                sum = temp.get((temp.size()/2)-1)+temp.get(temp.size()/2);
                median[index++] = sum/2;
            }
        }else {
            List<Double> temp = new ArrayList<>();
            for(;right<k;right++)
                temp.add((double) nums[right]);
            Collections.sort(temp);
            median[index++] = temp.get(temp.size()/2);
            for(;right<nums.length;right++){
                temp.remove((double)nums[left++]);
                temp.add((double) nums[right]);
                Collections.sort(temp);
                median[index++] = temp.get(temp.size()/2);
            }
        }
        return median;
    }
}