LinkedList<Integer> list = new LinkedList<>();
        int carry = 0;//11
                      // 1
        for(int i = a.length()-1,j=b.length()-1;i >= 0 || j >= 0 || carry == 1;i--,j--){
            int temp1 = i >= 0? a.charAt(i) - '0' : 0;
            int temp2 = j >= 0? b.charAt(j) - '0' : 0;
            int total = temp1 + temp2 + carry;
            if(total == 3){
                list.addFirst(1);
                carry =  1;
            }else if(total == 2){
                list.addFirst(0);
                carry = 1;
            }else if(total == 1){
                list.addFirst(1);
                carry = 0;
            }else{
                list.addFirst(0);
                carry = 0;
            }
        }
        StringBuilder s = new StringBuilder();
        for(var i : list)
            s.append(i);
        return s.toString();
    }