import java.util.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<food.length; i++){
            int cur = food[i]/2;
            sb.append(String.valueOf(i).repeat(cur));
        }
        String tmp = sb.reverse().toString();
        sb.reverse().append(0).append(tmp);
        
        return sb.toString();
    }
}