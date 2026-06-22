import java.util.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<my_string.length(); i++){
            char cur = my_string.charAt(i);
            if(cur>='a' && cur<='z') sb.append(Character.toUpperCase(cur));
            else sb.append(Character.toLowerCase(cur));
        }
        return sb.toString();
    }
}