class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        Set<String> set = new HashSet<>();
        for(var ban : banned)
            set.add(ban);
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0;i<paragraph.length();i++){
            StringBuilder temp = new StringBuilder();
            while(i < paragraph.length() && 
                  paragraph.charAt(i) >= 'a' && paragraph.charAt(i) <= 'z'){
                temp.append(paragraph.charAt(i++));
            }
            if(!set.contains(temp.toString()))
                map.merge(temp.toString(),1,Integer::sum);
        }
        int max = 0;
        String res = "";
        for(var item : map.keySet()){
            if(max < map.get(item) && !item.equals("")){
                max = map.get(item);
                res = item;
            }
        }
        
        return res;
    }
}