class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");

            int id = Integer.parseInt(parts[0]);
            String status = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (status.equals("start")) {
                if (!stack.isEmpty()) {
                    int cur = stack.peek();
                    answer[cur] += time-prevTime;
                }

                stack.push(id);
                prevTime = time;
            } else {
                int cur = stack.pop();
                answer[cur] += time-prevTime+1;

                prevTime = time+1;
            }
        }

        return answer;
    }
}