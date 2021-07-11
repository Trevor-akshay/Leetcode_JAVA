class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] answer = new int[queries.length];
       
        int[] words_frequency = new int[words.length];
        int i = 0;
        
        for(String k : words){
            words_frequency[i] = SmallestFrequency(k); 
            i++;
        }
        i = 0;
        for(String k : queries){
            int u = SmallestFrequency(k); 
            for(int j : words_frequency){
               if(u<j){
                   answer[i]++;
               }
           } 
            i++;
            
        }
        return answer;
        
        
    }
    
    public int SmallestFrequency(String word){ 
		int[] arr = new int[26]; 
        int min = 0;
        
        for(char element : word.toCharArray()){
            
            arr[(int)element-97]++;
        }
        
        
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i] !=0){
                min = arr[i];
                i = arr.length; 
            }
            
        }
       
        
        return min;
    }
}