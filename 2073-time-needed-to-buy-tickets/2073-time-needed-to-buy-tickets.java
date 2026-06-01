class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int idx = 0;
        int time = 0;

        while (tickets[k] > 0) {
            if (tickets[idx] > 0) {
                tickets[idx]--;
                time++;
                if (tickets[k] == 0) return time;
            }
            idx = (idx+1) % tickets.length;
        }

        return time;
    }
}