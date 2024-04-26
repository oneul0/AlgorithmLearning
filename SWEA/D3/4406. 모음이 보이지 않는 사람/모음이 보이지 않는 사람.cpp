#include<iostream>
#include <map>
using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);cin.tie(nullptr);
	int test_case;
	int T;
    map<char,bool> mp;
    mp.insert({'a',true});
    mp.insert({'e',true});
    mp.insert({'i',true});
    mp.insert({'o',true});
    mp.insert({'u',true});
    

	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        string s, ans="";
        cin >> s;
        for(char& c: s){
            if(mp[c]) continue;
            ans += c;
        }
        cout << '#'<<test_case<<" "<<ans<<'\n';
	}
	return 0;
}