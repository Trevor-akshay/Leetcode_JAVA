class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
       PriorityQueue<double[]> q = new PriorityQueue<>(
                Comparator.comparingDouble(o1 -> -o1[0])
        );
        for(var classe : classes){
            double val = getValue(classe[0],classe[1]);
            double first = classe[0];
            double second = classe[1];
            q.offer(new double[]{val,first,second});
        }
         double maxAverage = 0.0;
        while(extraStudents-- > 0){
            double[] temp = q.poll();
           // maxAverage += temp[0];
            temp[0] = getValue(temp[1]+1,temp[2]+1);
            q.offer(new double[]{temp[0],temp[1] +1,temp[2]+1});
        }
       while (!q.isEmpty()){
            double a = q.peek()[1];
            double b = q.poll()[2];
            maxAverage +=  a / b;
        }
        return maxAverage / classes.length;
    }

    private double getValue(double x,double y){
        return (x + 1) / (y + 1) - x/y ;
    }
}
