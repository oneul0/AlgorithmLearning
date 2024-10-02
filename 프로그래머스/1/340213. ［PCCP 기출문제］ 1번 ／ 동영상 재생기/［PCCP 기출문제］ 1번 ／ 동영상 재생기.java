import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = toSec(video_len);
        int posSec = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);

        for (String command : commands) {
            if (posSec >= opStart && posSec <= opEnd) posSec = opEnd;
            posSec += (command.equals("next") ? 10 : -10);
            posSec = Math.max(posSec, 0);
            posSec = Math.min(videoLen, posSec);
        }
        if (posSec >= opStart && posSec <= opEnd) posSec = opEnd;
        posSec = Math.min(posSec, videoLen);

        return tommss(posSec);
    }

    private int toSec(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String tommss(int sec) {
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }
}
