import java.util.*;
class Solution {
    class Truck{
        int weight;
        int enteredAt;
        Truck(int w, int e){
            this.weight = w;
            this.enteredAt = e;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int curWeight = 0;
        int nextTruckIdx = 0;
        Queue<Truck> bridge = new ArrayDeque<>();
        
        while(nextTruckIdx < truck_weights.length || !bridge.isEmpty()){
            time++;
            
            if(!bridge.isEmpty()){
                Truck first = bridge.peek();
                
                if(time  - first.enteredAt >= bridge_length){
                    curWeight-=first.weight;
                    bridge.poll();
                }
            }
            
            if(nextTruckIdx < truck_weights.length){
                int nextTruckWeight = truck_weights[nextTruckIdx];
                if(curWeight +nextTruckWeight <= weight){
                    bridge.offer(new Truck(nextTruckWeight, time));

                    curWeight += nextTruckWeight;
                    nextTruckIdx++;
                }    
            }
            
        }
        
        return time;
    }
}