class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        Outer : for(int i = left;i<=right;i++){
            int temp = i;
            while (temp != 0){
                int value = temp%10; // 1 2 8
                if(value == 0 || i % value != 0)
                    continue Outer;
                temp/=10;
            }
            list.add(i);
        }
        return list;
    }
}