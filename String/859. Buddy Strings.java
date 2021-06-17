public boolean buddyStrings(String a, String b) {
        if (a.equals(b)) {
            int[] count = new int[26];
            for (int i = 0; i < a.length(); ++i)
                count[a.charAt(i) - 'a']++;

            for (int c : count)
                if (c > 1) return true;
        }

        boolean swapped = false;
        StringBuilder S = new StringBuilder(a);
        Outer:
        for (int i = 0; i < a.length(); i++) {
            if (S.charAt(i) != b.charAt(i)) {
                for (int j = i; j < a.length(); j++) {
                    if (S.charAt(j) == b.charAt(i)) {
                        char temp = S.charAt(j);
                        S.setCharAt(j, S.charAt(i));
                        S.setCharAt(i, temp);
                        swapped = true;
                        if (S.toString().equals(b))
                            return true;
                        break Outer;
                    }
                }
            }
        }

        return false;
    }
