class Solution {
    public int findMinFibonacciNumbers(int k) {
          int count= 0;
            List<Integer> dp = new ArrayList<>();
            dp.add(0,1);
            dp.add(1,1);
            int i = 2;
            while (true){
                dp.add(i,dp.get(i-1) + dp.get(i-2));
                if(dp.get(i) > k)
                    break;
                i++;
            }
       
            int sum = 0;
            int right = dp.size() - 1;
            while(sum != k){
                sum += dp.get(right);
            if(sum > k){
                sum -= dp.get(right);
                right--;
            }else{
                count++;
            }
        }
            return count;}
}