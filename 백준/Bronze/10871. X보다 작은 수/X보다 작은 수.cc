#include <iostream>

using namespace std;

int main() {
	int a, b;
	cin >> a >> b;

	int c;
	
	for (int i = 0; i < a; i++) {
		cin >> c;
		
		if (c < b) {
			cout << c << " ";
		}
	}

	return 0;
}