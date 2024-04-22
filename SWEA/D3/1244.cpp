#include<iostream>
#include <algorithm>
#include <string>

using namespace std;

int ans, change;
string s;
void solution(int idx, int cur){
   	if(cur == change){
		ans = max(ans, stoi(s));
		return;
	}
	for(int i = idx; i<s.size(); i++){
		for(int j = i+1; j<s.size(); j++){
			if(s[i] <=s[j]){
				swap(s[i], s[j]);
				solution(i, cur+1);
				swap(s[i], s[j]);
			}
			if(i == s.size()-2 && j == s.size()-1){
				swap(s[i], s[j]);
				solution(i, cur+1);
				swap(s[i], s[j]);
			}
		}
	}
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	int T;

	cin>>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
		ans = 0;
        cin >> s >> change;
		if(change > s.size()) change = s.size();
		solution(0,0);
		cout << "#"<<test_case<<" "<<ans<<'\n';
	}
	return 0;
}