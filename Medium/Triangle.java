class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        System.out.println(triangle.size()-1);
        for (int row = triangle.size() - 2; row >= 0; row--) {
		for (int column = 0; column < triangle.get(row).size(); column++) {
			int min_cost = Math.min(triangle.get(row + 1).get(column), triangle.get(row + 1).get(column + 1)) + triangle.get(row).get(column);
			triangle.get(row).set(column, min_cost);
		}
	}
	return triangle.get(0).get(0);
    }
}