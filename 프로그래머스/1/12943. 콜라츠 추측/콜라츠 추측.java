class Solution {
    public int solution(int num) {
        int cnt = 0;
        while(num != 1 && cnt<=500){
            if(num%2==1) num = (num*3)+1;
            else num/=2;
            cnt++;
        }
        
        return cnt <=500 ? cnt : -1;
    }
}