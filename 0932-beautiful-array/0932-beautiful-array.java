class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while(result.size() < n){
            List<Integer> next = new ArrayList<>();

            for(int x : result){
                int odd = x*2-1;
                if(odd <= n){
                    next.add(odd);
                }
            }
            for(int x : result){
                int even = x*2;
                if(even <= n){
                    next.add(even);
                }
            }
            result = next;
        }

        int[] answer = new int[n];
        for(int i = 0; i<n; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}

//nums[k] == (nums[i] + nums[j])/2;
//어떤 beautiful array가 있을때, 그 배열의 짝수, 홀수 인덱스를 뽑아 만든 두 arr도  beautiful array임
