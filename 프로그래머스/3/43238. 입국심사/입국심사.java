class Solution {
    public long solution(int n, int[] times) {
        return bs(times, n);
    }
    
    public long bs(int[] times, int n){
        long l = 0;
        long r = 1_000_000_000L*100_000;
        while(l<r){
            long cnt = 0;
            long mid = (l+r)>>>1;
            
            for(int time : times){
                cnt += mid/time;
                if(cnt>=n) break;
            }
            if(cnt >= n){
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        return r;
    }
}

//answer++ 하며 특정 시점마다 나누어 떨어지는 times[i]를 찾았는데
//시간복잡도가 생각보다 많이 나오고 원하는대로 동작하지 않음
//되냐 안되냐 이진문제로 바꾸기 위해 특정 시점을 찾고
//그 시점에 모든 n을 처리할 수 있는지를 구하여 min time을 구하기