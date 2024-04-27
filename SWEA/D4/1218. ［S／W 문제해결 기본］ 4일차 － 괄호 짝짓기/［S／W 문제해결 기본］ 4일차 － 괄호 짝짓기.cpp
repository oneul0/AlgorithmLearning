#include<iostream>
#include <unordered_map>

using namespace std;

int pairing(unordered_map<char,int>& m){
    int flag = 1;
    if(m['['] != m[']']) flag = 0;
    if(m['('] != m[')']) flag = 0;
    if(m['{'] != m['}']) flag = 0;
    if(m['<'] != m['>']) flag = 0;
    return flag;
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	int T;
	
	for(test_case = 1; test_case <= 10; ++test_case)
	{
        string s;
        cin>>T;
        cin >> s;
        unordered_map<char,int> m;
        for(int i = 0; i<s.length(); i++){
            m[s[i]]++;
        }
        int ans = pairing(m);
        cout << '#' << test_case<<' '<<ans<<'\n';
	}
	return 0;
}