import java.util.*;
class Solution {
    public String solution(String s) {
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        StringBuilder sb = new StringBuilder();
        for(int i = tmp.length-1; i>=0; i--){
            sb.append(tmp[i]);
        }
        return sb.toString();
    }
}