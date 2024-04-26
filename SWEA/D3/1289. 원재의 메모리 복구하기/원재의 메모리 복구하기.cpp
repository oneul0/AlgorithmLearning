#include<iostream>
using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);cin.tie(nullptr);
	int test_case;
	int T;

	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        string s;
        int ans = 0, cur=0;
        cin >> s;
        for(int i = 0; i<s.size(); i++){
            if(s[i]-'0' != cur){
                ans++;
                cur ^= 1;
            }
        }
        cout << '#'<<test_case<<" "<<ans <<'\n';
	}
	return 0;
}