class Solution {
    public boolean isPathCrossing(String path) {
       Map<Integer,Set<Integer>> map = new HashMap<>();
       int x = 0;
       int y= 0;
       map.putIfAbsent(x,new HashSet<>());
       map.get(x).add(0);

       for(char c : path.toCharArray()){
           int[] temp = move(x,y,c);
           x=temp[0];
           y=temp[1];
           if(map.containsKey(x) && map.get(x).contains(y))
               return true;
           map.putIfAbsent(x,new HashSet<>());
           map.get(x).add(y);

       }
       return false;
    }

    static private int[] move(int x,int y,char c){
        switch (c){
            case 'N'->{
                if(y == -1)
                    y= 0;
                else
                    y+=1;
            }
            case 'S'->{
                if(y == 0)
                    y = -1;
                else
                    y-=1;
            }
            case 'E'->{
                if(x==-1)
                    x=0;
                else
                    x+=1;
            }
            case 'W'->{
                if(x ==0)
                    x=-1;
                else
                    x-=1;
            }
        }
        return new int[]{x,y};
    }
}