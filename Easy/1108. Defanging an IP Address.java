class Solution {
    public String defangIPaddr(String address) {
         StringBuilder stringBuilder = new StringBuilder();
        for(String value : address.split("\\.")){
            stringBuilder.append(value);
            stringBuilder.append("[.]");
        }
        return stringBuilder.toString().substring(0,stringBuilder.lastIndexOf("["));
    }
}