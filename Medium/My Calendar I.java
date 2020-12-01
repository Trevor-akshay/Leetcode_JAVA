class MyCalendar {

     List<int[]> calendar;

    MyCalendar() {
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] innerArray: calendar) {
            if (innerArray[0] < end && start < innerArray[1]) 
				return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}
