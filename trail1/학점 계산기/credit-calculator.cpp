#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    double sum = 0.0;
    for(int i = 0; i<n; i++){
        double x;
        cin >> x;
        sum += x;
    }
    sum /= n;
    cout << fixed;
    cout.precision(1);
    cout<<sum <<endl;
    if(sum >= 4.0) cout << "Perfect";
    else if(sum >= 3.0) cout << "Good";
    else cout << "Poor";
    return 0;
}