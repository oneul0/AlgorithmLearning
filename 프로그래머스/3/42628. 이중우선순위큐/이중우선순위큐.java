import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            String[] operation = op.split(" ");
            String command = operation[0];
            int num = Integer.parseInt(operation[1]);

            if (command.equals("I")) {
                minHeap.add(num);
                maxHeap.add(num);
            } else if (command.equals("D")) {
                if (minHeap.isEmpty()) {
                    continue;
                }

                if (num == 1) {
                    int maxValue = maxHeap.poll();
                    minHeap.remove(maxValue);
                } else if (num == -1) {
                    int minValue = minHeap.poll();
                    maxHeap.remove(minValue);
                }
            }
        }

        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}