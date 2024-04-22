#include<iostream>
#include <map>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	int T, tc, num;
	
	cin>>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
        map<int, int> m;
        cin >> tc;
        for(int i = 0; i<1000; i++){
            cin >> num;
            m[num]++;
        }
        auto pr = max_element(m.begin(), m.end(), [](const auto &x, const auto &y) {
                    if(x.second == y.second) return x.first<y.first;
                    return x.second < y.second;
                });
        cout << "#" << tc <<" "<<pr->first<<'\n';
	}
	return 0;
}