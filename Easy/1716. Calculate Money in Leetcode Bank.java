class Solution {
    public int totalMoney(int n) {
        int money = 0;
            int deposit = 1;
            int temp = deposit;
            int loop = 0;
            while(loop != n){
                if(loop !=0 && loop%7 == 0){
                    deposit++;
                    temp = deposit;
                }
                money += temp++;
                loop++;
            }
            return money;
        
    }
}