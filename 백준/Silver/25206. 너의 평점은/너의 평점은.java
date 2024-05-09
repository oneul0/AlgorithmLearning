import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        HashMap<String, Double> gradeMap = new HashMap<String, Double>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("F", 0.0);

        double total = 0;
        double scores = 0;
        for(int i = 0; i<20; i++){
            String str = br.readLine();
            String[] list = str.split(" ");
            if(list[2].equals("P")) continue;
            //0 : 과목명 1:학점 2:등급

            total += (Double.parseDouble(list[1])*gradeMap.get(list[2]));
            scores+=Double.parseDouble(list[1]);
        }
        total /= scores;
        // 소수점 자리 수를 지정하기 위한 DecimalFormat 객체 생성
        DecimalFormat decimalFormat = new DecimalFormat("#.######"); // 소수점 둘째 자리까지 표시하도록 설정

        // DecimalFormat을 사용하여 소수점 자리 수를 제한하고 BufferedWriter를 통해 출력
        bw.write(decimalFormat.format(total));
        br.close();
        bw.flush();
        bw.close();
    }
}
//과목명, 학점, 등급이 공백으로 구분되어 주어진다.
