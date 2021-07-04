class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> list = new ArrayList<>();
        int n = num.length();
        for(int i = 1;i<=n/2;i++){
            if(i > 1 && num.charAt(0) == '0'){
                return new ArrayList<>();
            }
            for(int j = i+1;j<n;j++){
                int first = 0,second = i,third = j;
                if(num.charAt(second) == '0' &&  third > second + 1 )
                    break;
                if(num.substring(first,second).length() > 10 || num.substring(second,third).length() > 10)
                    break;
                long temp1 = Long.parseLong(num.substring(first,second));
                long temp2 = Long.parseLong(num.substring(second,third));
                if(temp1 > (int)Math.pow(2,31) || temp2 > (int)Math.pow(2,31))
                    break;
                int x = (int)temp1;
                int y = (int)temp2;
                list.add(x);list.add(y);
                while(third<n){
                    x = Integer.parseInt(num.substring(first,second));
                    y = Integer.parseInt(num.substring(second,third));
                    Integer sum =  x + y;
                    if(num.substring(third).startsWith(sum.toString())){
                        list.add(sum);
                        first = second;
                        second = third;
                        third = third + sum.toString().length();
                    }
                    else{
                        list.clear();
                        break;
                    }
                }
                if(third == n){
                    return list;
                }
            }
        }
        return new ArrayList<>();
    }
}