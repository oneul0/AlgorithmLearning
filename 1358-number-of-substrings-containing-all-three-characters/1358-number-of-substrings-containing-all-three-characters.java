class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastIdx = {-1, -1, -1};
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            lastIdx[idx] = i;

            int minLastIdx = Math.min(lastIdx[0], Math.min(lastIdx[1], lastIdx[2]));

            if (minLastIdx != -1) {
                answer += minLastIdx + 1;
            }
        }

        return answer;
    }
}
//a b c 비트마스킹으로 하면 left가 확장될 때 처리 어려움