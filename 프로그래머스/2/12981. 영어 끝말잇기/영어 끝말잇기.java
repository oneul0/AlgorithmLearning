import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        String prev = words[0];
        Set<String> set = new HashSet<>();
        set.add(prev);
        for(int i = 1; i<words.length; i++){
            char plc= prev.charAt(prev.length()-1);
            if(plc != words[i].charAt(0)
              || set.contains(words[i])){
                return new int[]{(i%n)+1, (i/n)+1};
            }
            prev = words[i];
            set.add(words[i]);
        }
        
        return new int[2];
    }
}