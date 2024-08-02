class Solution {
    int[] numbers;
    int target;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(-numbers[0], 1);
        dfs(numbers[0], 1);
        return answer;
    }

    void dfs(int curNum, int depth){
        if(depth == numbers.length){
            if(curNum == target) answer++;
            return;
        }

        dfs(curNum+numbers[depth], depth+1);
        dfs(curNum-numbers[depth], depth+1);
    }
}