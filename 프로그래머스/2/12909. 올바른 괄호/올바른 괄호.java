import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> st = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            if(st.isEmpty() && s.charAt(i) == ')'){
            answer = false;
            return answer;    
            }
            if(st.isEmpty()||st.peek() == s.charAt(i)){
                st.push(s.charAt(i));
            }
            else{
                st.remove();
            }
        }

        if(!st.isEmpty()){
            answer = false;
        }
        return answer;
    }
}