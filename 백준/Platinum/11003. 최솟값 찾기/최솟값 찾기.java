import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, L;
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            int cur = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().num > cur){
                deque.removeLast();
            }
            deque.addLast(new Node(i, cur));

            if(deque.getFirst().idx <= i- L){
                deque.removeFirst();
            }
            bw.write(deque.getFirst().num+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

class Node {
    int idx, num;
    Node(int idx, int num){
        this.idx = idx;
        this.num = num;
    }
}