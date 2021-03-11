import java.io.*;
class Solution {
    int count = 0;
    public int numTilePossibilities(String tiles) {
         char[] chars = tiles.toCharArray();
        Set<String> set = new HashSet<>();
        StringBuilder str = new StringBuilder();
        numTilePossibilitiesHelper(set,chars,str,new boolean[tiles.length()]);
        return set.size();
    }

    static private void numTilePossibilitiesHelper(Set<String> set,char[] chars,
                                            StringBuilder str,boolean[] visited){
        if(str.length() != 0)
            set.add(str.toString());
        for(int i = 0;i<chars.length;i++){
            if(visited[i])
                continue;
            str.append(chars[i]);
            visited[i] = true;
            numTilePossibilitiesHelper(set,chars,str,visited);
            str.deleteCharAt(str.length()-1);
            visited[i] = false;
        }
    }
}
