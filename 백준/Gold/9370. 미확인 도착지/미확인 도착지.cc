#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <limits>
#define weight first
#define vertex second
const int INF = INT32_MAX;
using namespace std;
vector<vector<pair<int, int>>> adj;
void dijkstra(vector<int>& d, int st)
{
	d[st] = 0;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, st });
	while (!pq.empty())
	{
		pair<int, int> cur = pq.top(); pq.pop();
		if (cur.weight != d[cur.vertex])
		{
			continue;
		}
		for (pair<int, int> next : adj[cur.vertex])
		{
			if (d[cur.vertex] + next.weight < d[next.vertex])
			{
				d[next.vertex] = d[cur.vertex] + next.weight;
				pq.push({ d[next.vertex], next.vertex });
			}
		}
	}
}

int main(void)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int T;
	cin >> T;
	while (T--)
	{
		int n, m, t, s, g, h;
		cin >> n >> m >> t;
		cin >> s >> g >> h;

		adj.clear();
		adj.resize(n + 1);
		while (m--)
		{
			int a, b, c;
			cin >> a >> b >> c;
			adj[a].push_back({ c, b });
			adj[b].push_back({ c, a });
		}
		vector<int> terminator, ans;
		while (t--)
		{
			int node;
			cin >> node;
			terminator.push_back(node);
		}
        vector<int> S(n + 1, INF), G(n + 1, INF), H(n + 1, INF);
        dijkstra(S, s);
        dijkstra(G, g);
        dijkstra(H, h);
		for (int node : terminator)
		{
			bool isPossible = false;
            //필수 경로를 지나는 정점이 포함된 경로 중 최단 경로를 구함
            //s -> g -> h -> 목적지 or s -> h -> g -> 목적지
			if (S[node] == S[g] + G[h] + H[node] || S[node] == S[h] + H[g] + G[node])
			{
				isPossible = true;
			}
			if (isPossible)
			{
				ans.push_back(node);
			}
		}
		sort(ans.begin(), ans.end());
		for (int n : ans)
		{
			cout << n <<" ";
		}
		cout << '\n';
	}
}