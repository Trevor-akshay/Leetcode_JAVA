class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        partition(result,new ArrayList<>(),s,0);
        return result;
    }
    
     private void partition(List<List<String>> result,List<String> list,String s,int pos){
        if(pos == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos;i<s.length();i++){
            if(isPalindrome(s,pos,i)){
                list.add(s.substring(pos,i+1));
                partition(result,list,s,i+1);
                list.remove(list.size()-1);
            }
        }
    }

     private boolean isPalindrome(String s,int low,int high){
        while (low < high){
            if(s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
