class Solution {
    int[] schedules;
    int[][] timelogs;
    int startday;
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        this.schedules = schedules; this.timelogs = timelogs; this.startday = startday;
        
        for(int i = 0; i<schedules.length; i++){
            int newSchedule = scheduleCalc(schedules[i]);
            schedules[i] = newSchedule;
        }
        
        int answer = schedules.length;
        for(int i = 0; i<timelogs.length; i++){
            int day = startday;
            for(int j = 0; j<timelogs[i].length; j++){
                if((day <= 5) && timelogs[i][j] > schedules[i]){
                    answer--;
                    break;
                }
                day++;
                day = (day>7) ? day%7 : day;
            }
        }
        return answer;
    }
    public int scheduleCalc(int schedule){
        int newschedule = schedule;
        if(schedule%100 >= 50){
            newschedule = ((schedule/100)*100) + 100 + ((schedule%100)+10)%60;
        }
        else{
            newschedule+=10;
        }
        return newschedule;
    }
}
//1~5에 해당하는 시간만 계산
//schedules%100 > 59 이면 schedules + 100 + ((schedules%100)+10)%60
//출근 시간이 schedules +10 보다 큰지만 판단