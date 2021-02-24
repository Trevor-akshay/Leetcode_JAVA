class Solution {
    public int countPrimeSetBits(int L, int R) {
        int countPrimes = 0;
        for(int i = L;i<=R;i++){
            if(isPrime(Integer.bitCount(i)))
                countPrimes++;
        }
        return countPrimes;
    }
    
    private boolean isPrime(int x){
        int verify = (int)Math.sqrt(x);
        if(verify * verify == x)
            return false;
        
        for(int i = 2;i<=Math.sqrt(x);i++)
            if(x % i == 0)
                return false;
        
        return true;
    }
}
