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
        string s1, s2;
        int ans = 0, n=0;
        cin >> n;
        cin >> s1 >> s2;
        for(int i = 0; i<s1.size(); i++){
            if(s1[i] == s2[i]) ans++;
        }

        cout << '#'<<test_case<<" "<<ans <<'\n';
	}
	return 0;
}