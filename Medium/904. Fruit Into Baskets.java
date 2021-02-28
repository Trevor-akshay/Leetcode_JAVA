class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer,Integer> map = new HashMap<>();
        int left=0,right=0;
        int length = 0;
        while(right<tree.length){
            map.put(tree[right],map.getOrDefault(tree[right],0)+1);
            while(left < right && map.size() > 2){
                if(map.get(tree[left]) == 1)
                    map.remove(tree[left]);
                else
                    map.put(tree[left],map.get(tree[left])-1);
                left++;
            }
            length = Math.max(length,right-left+1);
            right++;
        }
        
        return length;
    }
}