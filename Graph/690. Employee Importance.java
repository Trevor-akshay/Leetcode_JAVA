/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> imp = new HashMap<>();
        buildGraph(employees,graph,imp);
        
        return dfs(id,graph,imp);
    }
    
    private void buildGraph(List<Employee> list,Map<Integer,List<Integer>> graph,
                           Map<Integer,Integer> imp){
        for(var l : list){
            int id = l.id;
            imp.put(id,l.importance);
            graph.put(id,l.subordinates);
        }
    }
    
    private int dfs(int vertex,Map<Integer,List<Integer>> graph,Map<Integer,Integer> imp){
        int value = imp.get(vertex);
        for(var edge : graph.get(vertex)){
            value += dfs(edge,graph,imp);
        }
        return value;
    }
}