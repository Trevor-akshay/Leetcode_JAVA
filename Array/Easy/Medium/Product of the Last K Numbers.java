class ProductOfNumbers {

    List<Integer> list;
    public ProductOfNumbers(){
        list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        
        int product = 1;
        int index = list.size()-k;
       
        for(;index<list.size();index++)
          product *=list.get(index);
        return product;
    }
}
