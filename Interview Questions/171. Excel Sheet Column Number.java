class Solution {
    public int titleToNumber(String columnTitle) {
       char arr[]=columnTitle.toCharArray();
        int sum=0,index=0;
        for(int i=arr.length-1;i>=0;i--)
        {
            sum+=Math.pow(26,index)*(((int)arr[i])-64);
            index++;
        }
        return sum;
    }
}