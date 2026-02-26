import java.util.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<food.length; i++){
            if(food[i] % 2 == 1){
                food[i]--;
            }
            for(int j = 0; j<food[i]/2; j++){
                sb.append(i);
            }
            
        }
        String rev = sb.reverse().toString();
        sb.reverse().append(0).append(rev);
        return sb.toString();
    }
}