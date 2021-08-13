class Solution {
          public int[] minDifference(int[] nums, int[][] queries) {

        SegmentTree segmentTree = new SegmentTree(nums);
        
        int[] result = new int[queries.length];
        
        for(int i = 0; i < result.length; i++){
            result[i] =  getMinDiff(queries[i], segmentTree);
        }
        
        
        return result;
    }
    
    private int getMinDiff(int[] query, SegmentTree segmentTree){
        //fiad all the number which are in query range 
        BitSet bitset = segmentTree.getAllNumberInRange(query[0], query[1]);
        
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        
        for(int num = 1; num <= 100; num++){
            if(!bitset.get(num)) continue;
            
            if(prev != -1){
                minDiff = Math.min(minDiff, num - prev);
            }
            
            prev = num;
        }
        
        
        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }
}

class SegmentTree{
    BitSet[] tree;
    BitSet base;
    int[] nums;
    int n;
    
    public SegmentTree(int[] nums){
        
        this.nums = nums;
        n = nums.length;
        
        tree = new BitSet[4 * n];
        base = new BitSet(101);
        
        
        buildTree(0, 0, n - 1);
    }
    
    private void buildTree(int treeIndex, int l, int r){
        if(l == r){
            tree[treeIndex] = new BitSet(101);
            tree[treeIndex].set(nums[l]);
            return;
        }
        
        int mid = l + (r - l) / 2;
        
        int leftChildIndex  = 2 * treeIndex + 1;
        int rightChildIndex = 2 * treeIndex + 2;
        
        
        buildTree(leftChildIndex, l, mid);
        buildTree(rightChildIndex, mid + 1, r);
        
        
        tree[treeIndex] = new BitSet(101);
        
        tree[treeIndex].or(tree[leftChildIndex]);
        tree[treeIndex].or(tree[rightChildIndex]);
    }
    
    
    public BitSet getAllNumberInRange(int qL, int qR){
        return query(0, 0, n - 1, qL, qR);
    }
    
    private BitSet query(int treeIndex, int l, int r, int qL, int qR){
        //outside the query range
        if(qL > r || l > qR) return base;
        
        //completely within the query range
        if(qL <= l && qR >= r) return tree[treeIndex];
        
        
        int mid = l + (r - l) / 2;
        int leftChildIndex  = 2 * treeIndex + 1;
        int rightChildIndex = 2 * treeIndex + 2;
        
        BitSet curr = new BitSet(101);
        
        //left sub part
        BitSet left = query(leftChildIndex, l, mid, qL, qR);
        
        //right sub part
        BitSet right = query(rightChildIndex, mid + 1, r, qL, qR);
        
        curr.or(left);
        curr.or(right);
        
        return curr;
    }
    
    
}