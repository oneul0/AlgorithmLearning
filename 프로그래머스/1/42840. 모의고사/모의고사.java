import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[][] stdt = new int[][]{{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] tmp = new int[3];
        int max = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<3; i++){
            for(int j = 0; j<answers.length; j++){
                if(stdt[i][j%(stdt[i].length)] == answers[j]) tmp[i]++;
                max = Math.max(max, tmp[i]);
            }
        }
        
        for(int i = 0; i<3; i++){
            if(tmp[i] == max) arr.add(i+1);
        }
        answer = new int[arr.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}

/*
1번 수포자가 찍는 방식: 1, 2, 3, 4, 5
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
*/