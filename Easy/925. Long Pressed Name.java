class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        if(name.charAt(name.length()-1) != typed.charAt(typed.length()-1) ||
            name.charAt(0) != typed.charAt(0))
            return false;
        int namePointer = 0;
        int typedPointer = 0;
        while(typedPointer < typed.length() && namePointer < name.length()){
            if(name.charAt(namePointer) == typed.charAt(typedPointer))
                namePointer++;
             if(namePointer >= 1 && name.charAt(namePointer-1) != typed.charAt(typedPointer))
            return false;
            typedPointer++;
        }
        while(typedPointer < typed.length()){
            if(name.charAt(name.length()-1) != typed.charAt(typedPointer++))
                return false;
        }
        return namePointer == name.length();
    }
}