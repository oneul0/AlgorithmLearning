class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] pi = new int[n];

        //kmp
        int j = 0;
        for(int i = 1; i<n; i++){
            //일치하지 않으면 이전 일치 위치로 후퇴
            while(j>0 && s.charAt(i) != s.charAt(j)){
                j = pi[j-1];
            }

            //일치하면 j 증가
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            pi[i] = j;
        }

        //pi[i-1]  = 가장 긴 길이
        int len = pi[n-1];
        return s.substring(0,len);
    }
}