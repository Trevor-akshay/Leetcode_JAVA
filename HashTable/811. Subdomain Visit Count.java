class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for(var cd : cpdomains){
            int index = cd.indexOf(' ');
            int value = Integer.parseInt(cd.substring(0,index));
            String toAdd = cd.substring(index+1);
            for(int i = 0;i<toAdd.length();i++){
                if(toAdd.charAt(i) == '.'){
                    map.merge(toAdd.substring(i+1),value,Integer::sum);
                }
            }
            map.merge(toAdd,value,Integer::sum);
        }
        List<String> list = new ArrayList<>();
        for(var val : map.keySet()){
            list.add(map.get(val) + " " +val);
        }        
        return list;
    }
}