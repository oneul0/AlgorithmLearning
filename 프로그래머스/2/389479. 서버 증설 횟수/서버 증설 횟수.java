class Solution {
    public int solution(int[] players, int m, int k) {
        int n = players.length;
        int[] diff = new int[n + k + 1];
        int currentServers = 0;
        int totalAdded = 0;

        for (int time = 0; time < n; time++) {
            // 현재 시점에 만료된 서버 반영 (차분 배열의 누적합)
            currentServers += diff[time];

            // 현재 필요한 서버 수 계산
            int neededServers = players[time] / m;

            // 부족하다면 증설
            if (currentServers < neededServers) {
                int additional = neededServers - currentServers;
                totalAdded += additional;
                currentServers += additional;

                //시간 만료
                if (time + k < diff.length) {
                    diff[time + k] -= additional;
                }
            }
        }
        return totalAdded;
    }
}