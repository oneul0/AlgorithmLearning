import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int p = 0, c = 0;
        while(c < completion.length){
            if(participant[p].equals(completion[c])){
                p++;
                c++;
            }
            else{
                answer = participant[p];p++;
            }
        }
        answer = answer == "" ? participant[p] : answer;
        return answer;
    }
}