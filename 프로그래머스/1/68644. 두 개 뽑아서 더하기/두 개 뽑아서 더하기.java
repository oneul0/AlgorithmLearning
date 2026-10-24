import java.util.*;
class Solution {
    List<Integer> arr = new ArrayList<>();
    int[] numbers;
    public int[] solution(int[] numbers) {
        this.numbers = numbers;
        dfs(0, 0, 0);
        Collections.sort(arr);
        int[] answer = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
    public void dfs(int depth, int start, int sum){
        if(depth == 2){
            if(arr.indexOf(sum) == -1){
                arr.add(sum);
            }
            return;
        }
        for(int i = start; i<numbers.length; i++){
            dfs(depth+1, i+1, sum + numbers[i]);
        }
    }
}