import java.io.*;

public class Main {
	static int[] heap;
	static int size = 0;

	static void push(int x) {
		heap[++size] = x;
		int i = size;

		while (i > 1 && heap[i] < heap[i / 2]) {
			int temp = heap[i];
			heap[i] = heap[i / 2];
			heap[i / 2] = temp;
			i /= 2;
		}
	}

	static int pop() {
		if (size == 0) return 0;

		int root = heap[1];
		heap[1] = heap[size--];

		int i = 1;
		while (i * 2 <= size) {
			int child = i * 2;

			if (child + 1 <= size && heap[child + 1] < heap[child]) {
				child++;
			}

			if (heap[i] <= heap[child]) break;

			int temp = heap[i];
			heap[i] = heap[child];
			heap[child] = temp;
			i = child;
		}

		return root;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		heap = new int[N + 1];
		for(int i = 0; i<N; i++){
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				System.out.println(pop());
			} else {
				push(num);
			}
		}
	}
}
