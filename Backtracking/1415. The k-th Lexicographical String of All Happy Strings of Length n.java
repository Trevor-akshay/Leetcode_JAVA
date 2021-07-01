class Solution {
    List<String> list = new ArrayList<>();
    int m;
    public String getHappyString(int n, int k) {
        m = k;
        helper(n,new StringBuilder(),new char[]{'a','b','c'},0);
        return m != 0 ?  "" : list.get(list.size()-1);
    }
    
    private void helper(int n,StringBuilder temp,char[] chars,int index){
        if(m == 0)
            return;
        if(temp.length() == n){
            list.add(temp.toString());
            m--;
            return;
        }
        index = index % chars.length;
        for(int i = index;i<chars.length;i++){
            if(temp.length() == 0 || temp.charAt(temp.length()-1) != chars[i]){
                temp.append(chars[i]);
                helper(n,temp,chars,0);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}