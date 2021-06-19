class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
		
		for(int i = 1;i <= numRows;i++){
			List<Integer> list = new ArrayList<>();
			list.add(1);
			int index = 0;
			while(index < i - 2){
				list.add(ans.get(ans.size() - 1).get(index) + ans.get(ans.size() - 1).get(index + 1) );
				index++;
			}
			if(i != 1)
			list.add(1);
			ans.add(list);
		}
		return ans;
    }
}