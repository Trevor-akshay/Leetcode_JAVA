class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        
        Outer:for(int i = 0;i<l.length;i++){
            int[] temp = new int[r[i] - l[i] + 1];
            if(temp.length < 2){
                res.add(false);
                continue;
            }
            System.arraycopy(nums,l[i],temp,0,r[i]-l[i] + 1);
            Arrays.sort(temp);
            int diff = temp[1] - temp[0];
            for(int j = 2;j<temp.length;j++){
                if(diff != temp[j] - temp[j-1]){
                    res.add(false);
                    continue Outer;
                }
            }
            res.add(true);
        }
        return res;
    }
}