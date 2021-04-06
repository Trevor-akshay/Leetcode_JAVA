class Solution {
    public String simplifyPath(String path) {
    Stack<String> s = new Stack<>();
        String [] arr = path.split("/");
       
        for(String dir: arr){
            if(dir.equals("") || dir.equals(".")){
                continue;
            }
            if(!s.isEmpty() && dir.equals("..")){
                s.pop();
            }
            else if(!dir.equals("..")){
                s.push(dir);
            }
        }
        List<String> ll = new ArrayList<>(s);
        return "/"+String.join("/",ll);
    }
}