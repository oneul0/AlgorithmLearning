import java.util.*;
public class Main {
    static final int MAX_N = 11;
    static int n, m;
    static ArrayList<int[]> lines = new ArrayList<>(), 
    selectedLines = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    //처음 상황과 선택한 가로줄만 사용했을 때의 상황 시뮬레이션해서
    //둘의 결과가 같은지
    public static boolean possible(){
        //init
        int[] num1 = new int[MAX_N];
        int[] num2 = new int[MAX_N];
        for(int i = 0; i<n; i++){
            num1[i] = num2[i] = i;
        }

        //위에서부터 순서대로 가로줄에 대해 양쪽 번호에 해당하는 숫자를 바꿔줌
        //원래 가로줄을 이용
        for(int i = 0; i<lines.size(); i++){
            int idx = lines.get(i)[1];
            int tmp = num1[idx];
            num1[idx] = num1[idx+1];
            num1[idx+1] = tmp;
        }
        //선택하거나 선택하지 않거나 새로운 배열을 만듦
        for(int i = 0; i<selectedLines.size(); i++){
            int idx = selectedLines.get(i)[1];
            int tmp = num2[idx];
            num2[idx] = num2[idx+1];
            num2[idx+1] = tmp;
        }
        //두 상황의 결과가 동일한지?
        for(int i = 0; i<n; i++){
            if(num1[i] != num2[i]) return false;
        }
        return true;
    }

    public static void findMinLines(int cnt){
        if(cnt == m){
            if(possible()) ans = Math.min(ans, selectedLines.size());
            return;
        }
        //선택하는 경우(가로줄 이용)
        selectedLines.add(lines.get(cnt));
        findMinLines(cnt+1);
        selectedLines.remove(selectedLines.size()-1);

        //선택하지 않는 경우
        findMinLines(cnt+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines.add(new int[]{b, a-1});
        }
        Collections.sort(lines, (a, b) -> Integer.compare(a[0], b[0]));
        findMinLines(0);
        System.out.print(ans);
    }
}
//가로줄을 새로 긋는 것이 아닌 주어진 가로줄 중 일부만을 이용해서 도달할 수 있는지를 판단해야함
//따라서 백트래킹을 이용할 경우 가로줄을 선택하거나(가로줄을 통해 이동하거나) 선택하지 않는 경우로 나뉨
