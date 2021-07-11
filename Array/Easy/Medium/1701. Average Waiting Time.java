class Solution {
    public double averageWaitingTime(int[][] customers) {
        int totalTime = customers[0][0]+customers[0][1];
        double time = totalTime-customers[0][0];
        for(int i = 1;i<customers.length;i++){
            if(customers[i][0] < totalTime){
                //System.out.println(totalTime);
            totalTime += customers[i][1];//1 2   3
               // System.out.println(totalTime);
            time +=totalTime - customers[i][0];
            }else{
                totalTime = customers[i][0]+customers[i][1];
                time+=totalTime - customers[i][0];
            }
        }
        return time/customers.length;
    }
}