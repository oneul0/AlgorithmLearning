class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        int sLen = s.length();
        for(int i = 0; i<sLen; i++){
            switch(s.charAt(i)){
                case 'p':
                    pCnt++;
                    break;
                case 'y':
                    yCnt++;
                    break;
                default:
                    break;
            }
        }

        return yCnt-pCnt == 0;
    }
}