class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Arrays.sort(arr);
        for (int i : arr) {
            int sb = Integer.bitCount(i);
            List<Integer> temp;
            if (map.containsKey(sb)) {
                temp = map.get(sb);
            } else {
                temp = new ArrayList<>();
            }
            temp.add(i);
            map.put(sb, temp);
        }
        int index = 0;
        for (int key : map.keySet()) {
            int[] temp = map.get(key).stream().mapToInt(i -> i).toArray();
            System.arraycopy(temp, 0, arr, index, temp.length);
            index += temp.length;
        }
        return arr;
    }
}