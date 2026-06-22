class Solution {
    public int magicalString(int n) {
        if(n <= 3) return 1;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[1] = arr[2] = 2;

        int head = 2;
        int tail = head;
        int answer = 1;

        while(tail< n){
            int count = arr[head];
            int val = 3-arr[tail];

            for(int i = 0; i<count; i++){
                arr[++tail] = val;
                if(tail<n && val == 1) answer++;
            }
            head++;
        }
        return answer;
    }
}