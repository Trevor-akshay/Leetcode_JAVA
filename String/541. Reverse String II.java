class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int temp = k;
      for(int i = 0;i<s.length();){
         swap(sb,i,k-1);
         i=k;
         i = temp+i;
         k = i+temp;
      }
        
        return sb.toString();
    }
    
    private void swap(StringBuilder sb,int i,int k){
        if(k > sb.length()-1)
            k = sb.length()-1;
        while(i < k){
            var temp = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(k));
            sb.setCharAt(k,temp);
            i++;
            k--;
        }
        
    }
}