import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String longS = s+s;
        for(int i = 0; i<s.length(); i++){
            if(isValid(longS.substring(i, i+s.length()))){
                answer++;
            }
        }
        return answer;
    }
    
    boolean isValid(String str){
        Deque<Character> st = new ArrayDeque<>();
        
        for(char cur : str.toCharArray()){
            if(cur == '[' || cur == '{' || cur == '('){
                st.push(cur);
            }
            else{
                if(st.isEmpty()) return false;
                
                char tmp = st.pop();
                if((tmp == '[' && cur != ']') ||
                  (tmp == '(' && cur != ')') ||
                   (tmp == '{' && cur != '}')){
                    return false;
                }
                    
            }
        }
//         여기까지 했는데 비었으면 유효한거임
        return st.isEmpty();
    }
}