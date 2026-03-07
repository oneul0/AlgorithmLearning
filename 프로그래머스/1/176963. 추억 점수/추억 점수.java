import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scores = new HashMap<>();
        for(int i = 0; i<name.length; i++){
            scores.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i = 0; i<answer.length; i++){
            for(String p : photo[i]){
                answer[i] += scores.getOrDefault(p, 0);
            }
        }
        return answer;
    }
}