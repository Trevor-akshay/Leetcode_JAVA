class Solution {
    public int romanToInt(String s) {
        int value = 0;
        Map<Character,Integer> romans = new HashMap<>();
        romans.put('I',1);
        romans.put('V',5);
        romans.put('X',10);
        romans.put('L',50);
        romans.put('C',100);
        romans.put('D',500);
        romans.put('M',1000);
        int i = 0;
        for(;i<s.length()-1;i++){
            if(s.charAt(i) == 'I' & s.charAt(i+1) == 'X'){
                value+=romans.get(s.charAt(i+1)) - romans.get(s.charAt(i));
                i++;
            }

            else if(s.charAt(i) == 'I' & s.charAt(i+1) == 'V'){
                value+=romans.get(s.charAt(i+1)) - romans.get(s.charAt(i));
                i++;
            }
            else if(s.charAt(i) == 'X' & s.charAt(i+1) == 'L'){
                value+=romans.get(s.charAt(i+1)) - romans.get(s.charAt(i));
                i++;
            }
            else if(s.charAt(i) == 'X' & s.charAt(i+1) == 'C'){
                value+=romans.get(s.charAt(i+1)) - romans.get(s.charAt(i));
                i++;
            }
            else if(s.charAt(i) == 'C' & s.charAt(i+1) == 'D'){
                value+=romans.get(s.charAt(i+1)) - romans.get(s.charAt(i));
                i++;
            }
            else if(s.charAt(i) == 'C' & s.charAt(i+1) == 'M'){
                value+=romans.get(s.charAt(i+1)) - romans.get(s.charAt(i));
                i++;
            }
            else
                value+=romans.get(s.charAt(i));
        }
        if(i==s.length()-1)
            value+=romans.get(s.charAt(s.length()-1));
        return value;
    }
}