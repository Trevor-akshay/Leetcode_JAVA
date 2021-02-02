class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> stackOperations = new ArrayList<>();
       int i = 0;
       int index = 0;
       while (i<n && index < target.length) {
           if(target[index] == i+1){{
               stackOperations.add("Push");
               index++;
               
           }
           }else{
               stackOperations.add("Push");
               stackOperations.add("Pop");
           }
           
           i++;
           }
       return stackOperations;
    }
}