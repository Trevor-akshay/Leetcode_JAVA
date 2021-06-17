class Solution {
    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(List.of('q','w','e','r','t','y','u','i','o','p'));
     Set<Character> row2 = new HashSet<>(List.of('a','s','d','f','g','h','j','k','l'));
     Set<Character> row3 = new HashSet<>(List.of('z','x','c','v','b','n','m'));

     List<String> list = new ArrayList<>();
     for(String word : words){
         char[] temp = word.toLowerCase().toCharArray();
         int row = 0;
         if(row1.contains(temp[0])) row = 1;
         else if(row2.contains(temp[0])) row = 2;
         else row = 3;
         for(char c : temp){
             if(row == 1 && !row1.contains(c)){
                 row = -1;
                 break;
             }
             else if(row == 2 && !row2.contains(c)){
                 row = -1;
                 break;
             }
             else if(row == 3 && !row3.contains(c)){
                 row = -1;
                 break;
             }
         }
         if(row != -1)
            list.add(word);
     }
     return list.toArray(new String[0]);
    }
}