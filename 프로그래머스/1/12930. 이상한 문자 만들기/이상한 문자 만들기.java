import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int diff = 'a' - 'A';
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);
            if (cur == ' ') {
                idx = 0;
            } else {
                cur = (idx % 2 == 0) ? Character.toUpperCase(cur) : Character.toLowerCase(cur);
                idx++;
            }
            
            sb.append(cur);
        }
        
        return sb.toString();
    }
}