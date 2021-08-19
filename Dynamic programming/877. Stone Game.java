class Solution {
    HashMap<Pair<Integer, Integer>, Boolean> seen = new HashMap<>();
    
    public boolean stoneGame(int[] piles) {
        return helper(1, piles.length - 1, piles, piles[0], 0, false) 
            || helper(0, piles.length - 2, piles, piles[piles.length - 1], 0, false);
    }
    
    private boolean helper(int start, int end, int[] piles, int alex, int lee, boolean isAlex) {
        if (seen.containsKey(new Pair<>(start, end))) {
            return seen.get(new Pair<>(start, end));
        }
        if (start > end) {
            return alex > lee;
        }
        if (start == end) {
            if (isAlex) {
                return alex + piles[start] > lee;
            } else {
                return alex > lee + piles[start];
            }
        }
        boolean res = true;
        if (isAlex) {
            res = helper(start + 1, end, piles, alex + piles[start], lee, !isAlex)
                || helper(start, end - 1, piles, alex + piles[end], lee, !isAlex);
        } else {
            res = helper(start + 1, end, piles, alex, lee + piles[start], !isAlex)
                || helper(start, end - 1, piles, alex, lee + piles[end], !isAlex);
        }
        seen.put(new Pair<>(start, end), res);
        return res;
    }
}