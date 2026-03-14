class Solution {
    private long maxLeaves = 0;
    private int dLim, sLim;

    public long solution(int dist_limit, int split_limit) {
        this.dLim = dist_limit;
        this.sLim = split_limit;
        
        // 루트의 자식 1개가 리프 노드인 상태에서 시작
        dfs(1, 1, 0, 1);
        
        return maxLeaves;
    }

    //S: 현재 깊이까지의 분배도 (부모들의 자식 수 곱)
    //N: 현재 깊이에 존재하는 노드 수
    //used: 현재까지 사용한 총 분배 노드 수
    //leaves: 현재 트리에서의 총 리프 노드 수
    private void dfs(long S, long N, long used, long leaves) {
        // 현재까지의 리프 노드 수 최댓값 갱신
        if (leaves > maxLeaves) {
            maxLeaves = leaves;
        }

        // 분배 노드를 더 이상 쓸 수 없거나 탐색할 노드가 없으면 종료
        if (used >= dLim || N == 0) return;

        // 현재 깊이의 분배 노드 자식 수를 2로 결정하면
        if (S * 2 <= sLim) {
            long m = Math.min(N, dLim - used); // 가능한 한 많이 분배 노드로 지정
            if (m > 0) {
                // 새 리프 수 = 기존 - m(분배노드될 것) + m*2(새로 생긴거) = 기존 + m
                dfs(S * 2, m * 2, used + m, leaves + m);
            }
        }

        // 현재 깊이의 분배 노드 자식 수를 3으로 결정하면
        if (S * 3 <= sLim) {
            long m = Math.min(N, dLim - used);
            if (m > 0) {
                // 새 리프 수 = 기존 - m + m*3 = 기존 + 2*m
                dfs(S * 3, m * 3, used + m, leaves + m * 2);
            }
        }
    }
}