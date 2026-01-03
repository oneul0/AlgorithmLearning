import java.io.*;
import java.util.*;

public class Main {

	static class Coord {
		int x, y, dist;
		Coord(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		Coord(int x, int y) {
			this(x, y, 0);
		}
	}

	static class Passenger {
		Coord start;
		Coord end;
		int roundDist;

		Passenger(Coord start, Coord end, int roundDist) {
			this.start = start;
			this.end = end;
			this.roundDist = roundDist;
		}
	}

	static int N, M, F;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	// BFS 최단 거리
	static int getShortestDist(Coord start, Coord end) {
		Deque<Coord> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][N + 1];

		q.add(start);
		visited[start.x][start.y] = true;

		while (!q.isEmpty()) {
			Coord cur = q.poll();

			if (cur.x == end.x && cur.y == end.y) {
				return cur.dist;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
				if (visited[nx][ny]) continue;
				if (map[nx][ny] == 1) continue;

				visited[nx][ny] = true;
				q.add(new Coord(nx, ny, cur.dist + 1));
			}
		}
		return -1;
	}

	static int solve(List<Passenger> ps, Coord taxi) {

		while (!ps.isEmpty()) {

			int idx = -1;
			int minDist = Integer.MAX_VALUE;

			// 태울 승객 선택
			for (int i = 0; i < ps.size(); i++) {
				Passenger p = ps.get(i);
				int dist = getShortestDist(taxi, p.start);
				if (dist == -1 || dist > F) continue;

				if (dist < minDist ||
					(dist == minDist &&
						(p.start.x < ps.get(idx).start.x ||
							(p.start.x == ps.get(idx).start.x && p.start.y < ps.get(idx).start.y)
						)
					)
				) {
					idx = i;
					minDist = dist;
				}
			}

			if (idx == -1) return -1;

			Passenger chosen = ps.get(idx);

			int carToPassenger = minDist;
			int startToEnd = chosen.roundDist;

			if (startToEnd == -1) return -1;
			if (carToPassenger + startToEnd > F) return -1;

			// 연료 계산
			F = F - carToPassenger - startToEnd + (startToEnd * 2);

			// 택시 위치 이동
			taxi = chosen.end;

			// 승객 제거
			ps.remove(idx);
		}

		return F;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		Coord taxi = new Coord(
			Integer.parseInt(st.nextToken()),
			Integer.parseInt(st.nextToken())
		);

		List<Passenger> ps = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Coord s = new Coord(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			);
			Coord e = new Coord(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			);
			int dist = getShortestDist(s, e);
			ps.add(new Passenger(s, e, dist));
		}

		System.out.println(solve(ps, taxi));
	}
}
