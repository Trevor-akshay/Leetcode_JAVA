class Solution {
    public List<String> invalidTransactions(String[] transactions) {
      List<String> result = new ArrayList<>();
        for(String string :transactions){
            if(result.contains(string)){
                continue;
            }
            String[] transactionI = string.split(",");
            if(Integer.parseInt(transactionI[2])>1000){
                if(!result.contains(string)){
                    result.add(string);
                }
            }
            else{
                for (String transaction : transactions) {
                    if (!string.equals(transaction)) {

                        String[] transactionJ = transaction.split(",");
                        if (Math.abs(Integer.parseInt(transactionI[1]) - Integer.parseInt(transactionJ[1])) <= 60
                                && transactionJ[0].equals(transactionI[0]) && !transactionJ[3].equals(transactionI[3])) {
                            if (!result.contains(string)) {
                                result.add(string);
                            }
                            if (!result.contains(transaction)) {
                                result.add(transaction);
                            }}}}}}
        return result;
    }
}