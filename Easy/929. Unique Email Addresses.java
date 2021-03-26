class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
      for (String email : emails) {
          StringBuilder s = new StringBuilder();
          boolean foundAt = false;
          for (int j = 0; j < email.length(); ) {
              char c = email.charAt(j);
              if (c == '@')
                  foundAt = true;
              if (c == '.' && !foundAt) {
                  j++;
                  continue;
              } else if (c == '+' && !foundAt) {
                  while (email.charAt(j) != '@')
                      j++;
                  foundAt = true;
              }
              s.append(email.charAt(j));
              j++;
          }
          set.add(s.toString());
      }
        return set.size();
    }
}