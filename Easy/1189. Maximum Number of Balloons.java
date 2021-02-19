class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map = new HashMap<>();

        for(char c : text.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character> list = List.of('b','a','l','l','o','o','n');
        int balloons = 0;
        boolean flag = false;
        while(true){
        for(char item : list){
            if(!map.containsKey(item) || map.containsKey(item) && map.get(item) == 0){
                flag = true;
                break;
            }else{
                map.put(item,map.get(item)-1);
            }
        }
        if(flag) break;
        balloons++;
        }
        return balloons;
    }
}