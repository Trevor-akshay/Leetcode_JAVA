class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
        if(digits.length() == 0)
            return result;
        Map<Character,String> map = Map.of(
                '2',"abc",'3',"def",'4',"ghi",'5',"jkl",
                '6',"mno", '7',"pqrs",'8',"tuv",'9',"wxyz");
        letterCombinationshelper(map,result,new StringBuilder(),digits,0);

        return result;
    }

    private void letterCombinationshelper(Map<Character,String> map,List<String> result,
                                                 StringBuilder s,String digits,int pos){
        if(pos == digits.length()){
            result.add(s.toString());
            return;
        }
        if(pos > digits.length())
            return;
        String value = map.get(digits.charAt(pos));
        for(int i = 0;i<value.length();i++){
            s.append(value.charAt(i));
            letterCombinationshelper(map,result,s,digits,pos+1);
            s.deleteCharAt(s.length()-1);
        }
}
}