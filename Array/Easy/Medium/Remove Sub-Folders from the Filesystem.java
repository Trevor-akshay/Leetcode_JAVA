class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> list = new ArrayList<>();
        Arrays.sort(folder);
        String fold = folder[0];
        list.add(fold);
        int index =1;
        while (index < folder.length){
            String fold2 = folder[index];
            if(fold2.startsWith(fold+"/"))
                index++;
            else{
                fold = folder[index];
                list.add(fold);
                index++;
            }
        }
       // System.out.println(Arrays.toString(folder));
        return list;
    }
}