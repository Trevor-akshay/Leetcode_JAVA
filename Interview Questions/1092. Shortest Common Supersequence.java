class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String[][] mem = new String[str1.length()][str2.length()];
        String res = memSol(str1, str2, 0, 0, mem);
        if(res.length() == 0) return str1+str2;
        
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        for(char c: res.toCharArray()){
            while(str1.charAt(i) != c) ans.append(str1.charAt(i++));
            while(str2.charAt(j) != c) ans.append(str2.charAt(j++));
            ans.append(c);
            i++; j++;
        }
        ans.append(str1.substring(i));
        ans.append(str2.substring(j));
        return ans.toString();
    }
    
    public String memSol(String s1, String s2, int i, int j, String[][] mem){
        if(i >= s1.length() || j >= s2.length()) return "";
        
        if(mem[i][j] != null) return mem[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            mem[i][j] = s1.charAt(i) + memSol(s1, s2, i+1, j+1, mem);
        }else{
            String left = memSol(s1, s2, i+1, j, mem);
            String right = memSol(s1, s2, i, j+1, mem);
            
            mem[i][j] = (left.length() >= right.length()) ? left : right;
        }
    
        return mem[i][j];
    }
}