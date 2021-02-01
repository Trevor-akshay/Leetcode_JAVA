class Cashier {
 int n;
    int discount;
    Map<Integer,Integer> productPrices = new HashMap();
    int tempN = 1;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for(int i = 0;i<prices.length;i++){
            productPrices.put(products[i],prices[i]);
         }
        }

    public double getBill(int[] product, int[] amount) { // product = 1  2  amount   = 1  2
        double bill = 0;
        for(int i = 0;i<product.length;i++){
            bill+=productPrices.get(product[i]) * amount[i];
        }
        if(tempN == n){
            tempN = 1;
            return bill - ((bill*discount)/100);
        }
        tempN++;

        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */