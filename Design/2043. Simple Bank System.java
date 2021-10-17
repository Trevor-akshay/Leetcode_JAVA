class Bank {
    long[] A;
    public Bank(long[] A) {
        this.A = A;
    }
    
    public boolean transfer(int account1, int account2, long money) {
         if(account1 == account2)
             return money <= A[account1 - 1];
         if(account1 <= A.length && A.length >= account2){
            if(A[account1 - 1] >= money){
                A[account2 - 1] +=  money;
                A[account1 - 1] -=  money;
                return true; 
          }
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(A.length >= account){
            A[account - 1] += money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(A.length >= account){
            if(A[account - 1] >= money){
                A[account - 1] -= money;
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */