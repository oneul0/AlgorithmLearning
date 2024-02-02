#include<iostream>
#include<vector>
#include<queue>

using namespace std;

queue<pair<int,int>> q;
vector<int> numbers;
int target;
int solution(vector<int> numbers, int target){
    int answer = 0;
    int Size = numbers.size();

    q.push(make_pair(numbers[0], 1));
    q.push(make_pair(-numbers[0], 1));

    while(!q.empty()){
        int num = q.front().first;
        int cnt = q.front().second;

        q.pop();

        if(cnt == Size){
            if(num == target){
                cout<< "same num : " << num << "t cnt : " << cnt <<endl;
                answer++;
            }
        }
        else{
            cout << "num : " << num << " "<< "numbers[cnt] : " << numbers[cnt] << " " << "cnt : " <<cnt <<endl;
            q.push(make_pair(num+numbers[cnt], cnt+1));
            q.push(make_pair(num-numbers[cnt], cnt+1));
            
        }
    }
    return answer;
}

int main(){
    
    for(int i = 0; i<4; i++){
        int w;
        cin >> w;
        numbers.push_back(w); 
    }
    cin >> target;
    int ans = solution(numbers, target);
    cout << ans;
    return 0;

}