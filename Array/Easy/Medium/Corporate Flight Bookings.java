class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
         int[] flights = new int[n];
        for(int[] booked : bookings){
            for(int i = booked[0];i<=booked[1];i++)
                flights[i-1]+=booked[2];
        }
        //System.out.println(Arrays.deepToString(bookings));
        return flights;
    }
}