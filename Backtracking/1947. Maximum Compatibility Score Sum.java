class Solution {
    int maxScore = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        helper(students,mentors,0,0,new boolean[mentors.length]);
        return maxScore;
    }

    private void helper(int[][] s,int[][] h,int pos,int temp,boolean[] v){
        if(pos == s.length){
            maxScore = Math.max(maxScore,temp);
            return;
        }
        
        for(int i = 0;i<s.length;i++){
            if(!v[i]){
                v[i] = true;
                int value = sum(s[pos],h[i]);
                temp += value;
                helper(s,h,pos+1,temp,v);
                v[i] = false;
                temp -= value;
            }
        }
    }

    private int sum(int[] s,int[] m){
        int count = 0;
        for(int i = 0;i<s.length;i++)
            count = s[i] == m[i] ? count + 1: count;

        return count;
    }
}