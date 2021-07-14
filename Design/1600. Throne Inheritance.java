class ThroneInheritance {
    String name;
    Map<String,List<String>> map = new HashMap<>();
    Set<String> isAlive = new HashSet<>();
    public ThroneInheritance(String kingName) {
        this.name = kingName;
    }

    public void birth(String parentName, String childName) {
        map.putIfAbsent(parentName,new ArrayList<>());
        map.get(parentName).add(childName);
    }

    public void death(String name) {
        isAlive.add(name);

    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        getNames(result,name);

        return result;

    }

    private void getNames(List<String> res,String name){
        if(!isAlive.contains(name))
            res.add(name);
        for(var child : map.getOrDefault(name,new ArrayList<>()))
            getNames(res,child);
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */