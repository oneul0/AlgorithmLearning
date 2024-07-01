class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length};
        int s = 0, e = 0;
        long total = 0;
        while(e < sequence.length) {
            total += sequence[e];
            while(total > k && s <= e){
                total -= sequence[s];
                s++;
            }
            if(total == k){
                if(answer[1] - answer[0] > e - s){
                    answer = new int[]{s,e};
                }
            }
            e++;
        }

        return answer;
    }
}