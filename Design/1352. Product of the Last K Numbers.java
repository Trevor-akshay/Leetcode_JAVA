class ProductOfNumbers {

    List<Integer> products;
    int lastZero;
    
    public ProductOfNumbers() {
        products = new ArrayList<>();
        lastZero = -1;
    }
    
    public void add(int num) {
        if(num == 0){
            lastZero = products.size();
            products.add(1);
        }else{
            if(products.size() == 0) products.add(num);
            else products.add(products.get(products.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        if(products.size() - k <= lastZero) return 0;
        if(k == products.size()) return  products.get(products.size() - 1);
        return products.get(products.size() - 1) / products.get(products.size() - k - 1); 
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */