class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        List<Integer> studentList = new ArrayList<>();
        for(int item : students)
            studentList.add(item);
        List<Integer> sandwichList = new ArrayList<>();
        for(int item : sandwiches)
            sandwichList.add(item);
        int looped = 0;
        while(true){
            if(studentList.get(0).equals(sandwichList.get(0))){
                sandwichList.remove(0);
                studentList.remove(0);
                looped =0;
            }else{
                int temp = studentList.remove(0);
                studentList.add(temp);
                looped++;
            }
            if(looped == studentList.size() || sandwichList.isEmpty())
                break;
        }
        return studentList.size();
    }
}