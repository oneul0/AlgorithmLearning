import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			String line;

			while (!(line = br.readLine()).equals("end")) {
				for (char c : line.toCharArray()) {
					if(c == '%') break;
					if(c == '>' || c == '<' || c == '+' || c == '-' || c == '.' || c == '[' || c == ']') {
						sb.append(c);
					}
				}
			}

			String code = sb.toString();
			int[] pair = new int[code.length()];
			if(!findPairs(code, pair)) {
				System.out.println("PROGRAM #" + t + ":");
				System.out.println("COMPILE ERROR");
				continue;
			}

			System.out.println("PROGRAM #" + t + ":");
			System.out.println(execute(code, pair));
		}
	}

	// 괄호 짝 계산
	static boolean findPairs(String code, int[] pair) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < code.length(); i++) {
			if(code.charAt(i) == '[') {
				stack.push(i);
			}
			else if(code.charAt(i) == ']') {
				if (stack.isEmpty()) return false;
				int openIdx = stack.pop();
				pair[openIdx] = i;
				pair[i] = openIdx;
			}
		}
		return stack.isEmpty();
	}

	static String execute(String code, int[] pair) {
		int[] memory = new int[32768];
		int ptr = 0;
		int ip = 0;
		StringBuilder result = new StringBuilder();

		while (ip < code.length()) {
			char cmd = code.charAt(ip);

			switch (cmd) {
				case '>':
					ptr = (ptr + 1) % 32768;
					break;
				case '<':
					ptr = (ptr + 32767) % 32768;
					break;
				case '+':
					memory[ptr] = (memory[ptr] + 1) % 256;
					break;
				case '-':
					memory[ptr] = (memory[ptr] + 255) % 256;
					break;
				case '.':
					result.append((char) memory[ptr]);
					break;
				case '[':
					if (memory[ptr] == 0) ip = pair[ip];
					break;
				case ']':
					if (memory[ptr] != 0) ip = pair[ip];
					break;
			}
			ip++;
		}
		return result.toString();
	}
}