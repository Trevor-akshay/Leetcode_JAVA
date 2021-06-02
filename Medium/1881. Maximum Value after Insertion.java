class Solution {
    public String maxValue(String n, int x) {
        boolean negative = n.charAt(0) == '-';
        StringBuilder temp = new StringBuilder(n);
        boolean inserted = false;
        if(negative){
            for(int i = 1;i<n.length();i++){
                int value = Integer.parseInt(n.charAt(i) + "");
                if(value > x){
                    temp.insert(i,x);
                    inserted = true;
                    break;
                }
            }
            if(!inserted)
                temp.append(x);

        }else{
            for(int i = 0;i<n.length();i++){
                int value = Integer.parseInt(n.charAt(i) + "");
                    
                if(value < x){
                    temp.insert(i,x);
                    inserted = true;
                    break;
                }
            }
            if(!inserted)
                temp.append(x);
        }
        return temp.toString();
    }
}