class Solution {
    int answer = 0, target = 0;
    int[] numbers;
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        dfs(numbers[0], 1);
        dfs(-numbers[0], 1);
        
        return answer;
    }
    
    void dfs(int num, int depth){
        if(depth == numbers.length){
            if(num == target) answer++;
            return;
        }
        
        dfs(num+numbers[depth], depth+1);    
        dfs(num-numbers[depth], depth+1);
    }
}