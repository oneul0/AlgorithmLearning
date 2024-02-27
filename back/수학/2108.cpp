// #include <iostream>
// #include <cmath>
// #include <vector>
// #include <numeric>
// #include <algorithm>
// #include <map>


// using namespace std;

// int n,a, aver, middle, freq, ran,s=0;
// vector<int> v,v2;
// map<int,int> m;

// void average(){
//     //산술평균 : N개의 수들의 합을 N으로 나눈 값
//     aver = round(double(s / v.size()));
// }
// void middleNum(){
//     //중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
//     middle = v[v.size()/2];
// }
// void mode(){
//     //최빈값 : N개의 수들 중 가장 많이 나타나는 값
//     vector<pair<int,int>> tmp(m.begin(), m.end());
//     freq = tmp.back().first;
// }
// void range(){
//     //범위 : N개의 수들 중 최댓값과 최솟값의 차이
//     ran = v[n-1]-v[0];
// }

// int main(){
//     cin >> n;
//     v.resize(n);
//     v2.resize(n);
//     for(int i = 0; i<n; i++){
//         int num;
//         cin >> num;
//         v[n] = num;
//         s+= num;
//         m[num]++;
//     }

//     sort(v.begin(), v.end());
//     //s = accumulate(v.begin(), v.end(), 0); //요소 합
//     average();
//     middleNum();
//     mode();
//     range();

//     cout << aver <<"\n"<< middle  <<"\n"<< freq  <<"\n"<< ran;

//     return 0;
// }

#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <unordered_map>
using namespace std;

int main()
{
	int N, sum = 0;
	cin >> N;
	vector<int> v(N);
	unordered_map<int, int> freq;

	for (int i = 0; i < N; i++)
	{
		cin >> v[i];
		sum += v[i];
		freq[v[i]]++;
	}

	sort(v.begin(), v.end());

	int size = v.size();

	int mean = round((double)sum / size);

	int center = v[size / 2];

	vector<pair<int, int>> tmp(freq.begin(), freq.end());
	sort(tmp.begin(), tmp.end(), [](auto const& l, auto const& r)
		{
			return l.second != r.second ? l.second > r.second : l.first < r.first;
		});

	int fre = tmp[0].first;

	if (tmp.size() > 1 && tmp[0].second == tmp[1].second)
		fre = tmp[1].first;

	int range = v[size - 1] - v[0];
	
	std::cout << mean << '\n' << center << '\n' << fre << '\n' << range << '\n';
}