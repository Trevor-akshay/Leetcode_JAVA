class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(0);
			return list;
		}
		List<Integer> pre = grayCode(n - 1);
		List<Integer> cur = new ArrayList<Integer>(pre);
		int add = (int) Math.pow(2, n - 1);
		for (int i = pre.size() - 1; i >= 0; i--) {
			cur.add(pre.get(i) + add);
		}
		return cur;
    }
}