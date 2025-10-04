import java.util.*;
import java.util.stream.Collectors;

class Solution {
    class CarInfo implements Comparable<CarInfo> {
        int number;
        int fee;

        CarInfo(int number, int fee) {
            this.number = number;
            this.fee = fee;
        }

        @Override
        public int compareTo(CarInfo o) {
            return this.number - o.number;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> in_time = new HashMap<>();

        Map<Integer, Integer> total_times = new HashMap<>();

        for (String record : records) {
            String[] info = record.split(" ");
            int time = time_2_min(info[0]);
            int number = Integer.parseInt(info[1]);
            String status = info[2];

            if (status.equals("IN")) {
                in_time.put(number, time);
            } else if (status.equals("OUT")) {
                int inTime = in_time.remove(number);
                int parkingTime = time - inTime;

                total_times.put(number, total_times.getOrDefault(number, 0) + parkingTime);
            }
        }

        int close_time = time_2_min("23:59");
        
        for (Map.Entry<Integer, Integer> entry : in_time.entrySet()) {
            int number = entry.getKey();
            int inTime = entry.getValue();

            int parkingTime = close_time - inTime;
            
            total_times.put(number, total_times.getOrDefault(number, 0) + parkingTime);
        }

        List<CarInfo> car_list = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> entry : total_times.entrySet()) {
            int number = entry.getKey();
            int totalParkingTime = entry.getValue();

            int finalFee = get_total_fee(totalParkingTime, fees);
            
            car_list.add(new CarInfo(number, finalFee));
        }

        Collections.sort(car_list);

        return car_list.stream()
                .mapToInt(car -> car.fee)
                .toArray();
    }

    public int get_total_fee(int total_time, final int[] fees) {
        if (total_time <= fees[0]) {
            return fees[1];
        }

        int extra_time = total_time - fees[0];
        
        int extra_units = (int) Math.ceil((double) extra_time / fees[2]);
        
        int total_fee = fees[1] + extra_units * fees[3];

        return total_fee;
    }

    public int time_2_min(String time) {
        String[] HHMM = time.split(":");
        int hh_2_mm = Integer.parseInt(HHMM[0]) * 60;
        int mm = Integer.parseInt(HHMM[1]);
        return hh_2_mm + mm;
    }
}