class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
         int l=Integer.toString(low).length(), u=Integer.toString(high).length();
        List<Integer> list=new ArrayList<>();
        
        for(int i=l;i<=Math.min(u,9);i++){
            
            String add="";
            int n=0;
            for(int j=1;j<=i;j++){
                add+=1;
                n*=10;
                n+=j;
            }
            if(n>=low && n<=high)
                list.add(n);
            
            while(n%10!=9){
                
                n+=Integer.parseInt(add);
                if(n>=low && n<=high)
                    list.add(n);
                
            }
            
        }
        
        return list;
    }
}