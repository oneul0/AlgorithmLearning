import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String extendedS = s + s;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            Deque<Character> st = new ArrayDeque<>();
            boolean flag = true;
            for (int j = i; j < len+i; j++) {
                char c = extendedS.charAt(j);
                if (st.isEmpty() && (c == ']' || c == '}' || c == ')')) {
                    flag = false;
                    break;
                }
                if (c == '[' || c == '{' || c == '(') {
                    st.add(c);
                } else if ((st.peekLast() == '[' && c == ']')
                        || (st.peekLast() == '{' && c == '}')
                        || (st.peekLast() == '(' && c == ')')) {
                        st.removeLast();
                }
            }
            if (flag && st.isEmpty()) answer++;
        }


        return answer;
    }
}