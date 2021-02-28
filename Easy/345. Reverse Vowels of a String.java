class Solution {
    public String reverseVowels(String s) {
        int left = 0,right = s.length()-1;
        StringBuilder str = new StringBuilder(s);
        while(left < right){
            if(isVowel(str.charAt(left)) && isVowel(str.charAt(right))){
                char c = str.charAt(left);
                str.replace(left,left+1,s.charAt(right)+"");
                str.replace(right,right+1,s.charAt(left)+"");
                left++;right--;
            }else if(!isVowel(str.charAt(left)) && isVowel(str.charAt(right)))
                left++;
            else if(isVowel(str.charAt(left)) && !isVowel(str.charAt(right)))
                right--;
            else{
                left++;right--;
            }
        }
        return str.toString();
    }
    
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i'|| c== 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I'|| c== 'O' || c == 'U' ;
        
    }
}