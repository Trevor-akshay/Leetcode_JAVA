class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() > 4 * 4)
            return list;
        
        for(int i = 1;i<4 && i < s.length();i++){
            for(int j = i + 1 ; j< i + 4 && j < s.length();j++){
                for(int k = j + 1;k< j + 4 && k < s.length();k++){
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,s.length());
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        list.add(s1 +"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return list;
    }
    
    private boolean isValid(String s){
        if(s.charAt(0) == '0' && s.length() > 1)
            return false;
        return s.length() <= 3 &&  Integer.parseInt(s) <= 255;
    }
}