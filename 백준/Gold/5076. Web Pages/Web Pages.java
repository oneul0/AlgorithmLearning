import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String line;
		while((line = br.readLine()) != null){
			if(line.equals("#")) break;

			if(isValid(line)){
				System.out.println("legal");
			}
			else{
				System.out.println("illegal");
			}
		}
		br.close();
	}

	public static boolean isValid(String html){
		Deque<String> stack = new ArrayDeque<>();
		int i = 0;
		while(i<html.length()){
			if(html.charAt(i) == '<'){
				//가장 가까운 닫힌 괄호 찾기
				int endIdx = html.indexOf('>', i);
				if(endIdx == -1){
					return false;
				}

				String tag = html.substring(i+1, endIdx);

				if(tag.endsWith("/")){
					//자체 닫힌 태그는 아무것도 안함
				}
				else if(tag.startsWith("/")){
					//닫힌 태그
					//시작 인덱스 1
					String tagName = tag.substring(1).trim();
					int spaceIdx = tagName.indexOf(' ');
					if(spaceIdx != -1){
						tagName = tagName.substring(0, spaceIdx);
					}

					if(stack.isEmpty()){
						return false;
					}

					String openTag = stack.pop();
					if(!openTag.equals(tagName)){
						return false;
					}

				}
				else{
					//열린 태그
					String tagName = tag.trim();
					int spaceIdx = tagName.indexOf(' ');
					if(spaceIdx != -1){
						tagName = tagName.substring(0, spaceIdx);
					}
					stack.push(tagName);
				}
				i = endIdx +1;
			}
			else{
				i++;
			}
		}
		//모든 태그가 닫혔는지
		return stack.isEmpty();
	}
}
