import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Stack<Integer> st = new Stack<>();

        String input = br.readLine();
        int n = Integer.parseInt(input);
        long[] roofs = new long[n];
        for (int i = 0; i < n; i++) {
            int building = Integer.parseInt(br.readLine());
            roofs[i] = building;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && roofs[st.peek()] <= roofs[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans += st.size();
            }

            st.push(i);
        }

        bw.write(Long.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }

}
