import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> st = new Stack<>();
        long answer = 0;

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            int count = 1;

            while (!st.isEmpty() && st.peek()[0] <= height) {
                answer += st.peek()[1];
                if (st.peek()[0] == height) {
                    count = st.pop()[1] + 1;
                } else {
                    st.pop();
                }
            }

            if (!st.isEmpty()) {
                answer++;
            }

            st.push(new int[]{height, count});
        }

        bw.write(Long.toString(answer));
        bw.flush();
        br.close();
        bw.close();
    }
}
