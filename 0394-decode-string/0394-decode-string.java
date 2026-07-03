class Solution {
    private int index = 0;

    public String decodeString(String s) {
        index = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder result = new StringBuilder();
        int number = 0;

        while(index<s.length()) {
            char ch = s.charAt(index);

            if(Character.isDigit(ch)) {
                number = number * 10+(ch-'0');
                index++;
            } 
            else if(ch=='[') {
                // [ pass
                index++;

                String decoded = decode(s);

                for (int i = 0; i < number; i++) {
                    result.append(decoded);
                }

                number = 0;
            } 
            else if(ch==']') {
                // ] pass
                index++;
                return result.toString();
            } 
            else {
                result.append(ch);
                index++;
            }
        }

        return result.toString();
    }
}