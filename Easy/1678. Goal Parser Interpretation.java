class Solution {
    public String interpret(String command) {
       StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ;i<command.length();i++){
            if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                stringBuilder.append("o");
                i=i+1;
            }
            else if(command.charAt(i) == '(' && Character.isAlphabetic(command.charAt(i+1))){
                while (command.charAt(++i) != ')'){
                    stringBuilder.append(command.charAt(i));

                }

            }
            else
                stringBuilder.append(command.charAt(i));
        }

        return stringBuilder.toString();
    }
}