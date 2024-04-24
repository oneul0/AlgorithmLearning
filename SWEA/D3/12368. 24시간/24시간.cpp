#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	int T,s,e;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        cin >> s >> e;
        cout << '#' << test_case << " " << (s+e)%24<<'\n';
	}
	return 0;
}