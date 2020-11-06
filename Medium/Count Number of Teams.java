class Solution {
    public int numTeams(int[] rating) {
        if(rating.length < 3) return 0;
        int count = 0;
        for(int i = 0;i<rating.length;i++){
            for(int j = i+1;j<rating.length;j++){
                for(int k=j+1;k<rating.length;k++){
                    if(rating[i]<rating[j] && rating[j]<rating[k])
                        count++;
                    else if(rating[i]>rating[j] && rating[j]>rating[k])
                        count++;
                }
            }
        }
        return count;
    }
}