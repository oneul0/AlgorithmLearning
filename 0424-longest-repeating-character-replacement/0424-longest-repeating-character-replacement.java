class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int answer = 0;

        for(int right = 0; right<s.length(); right++){
            int curIdx = s.charAt(right)-'A';
            count[curIdx]++;

            maxCount = Math.max(maxCount, count[curIdx]);

            int windowLen = right - left + 1;

            //맨 왼쪽 문자열 제거
            if(windowLen - maxCount > k){
                int leftCharIdx = s.charAt(left)-'A';
                count[leftCharIdx]--;
                left++;
            }
            answer = Math.max(answer, right-left+1);
        }

        return answer;
    }
}
//구간의 알파벳 중 큰 것이 x라고 했을 때 구간의 길이 - x 가 k보다 작거나 같으면 가능