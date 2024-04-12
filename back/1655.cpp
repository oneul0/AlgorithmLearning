//최소힙, 최대힙 두 가지를 모두 이용

#include <iostream>
#include <queue>

using namespace std;

//부모가 자식보다 크거나 같은 완전이진트리 -> 트리(우선순위큐)의 값을 내림차순으로 정렬
priority_queue<int> max_heap;
//부모가 자식보다 작거나 같은 완전이진트리 -> 트리(우선순위큐)의 값을 오름차순으로 정렬
priority_queue<int, vector<int>, greater<int>> min_heap;
int n,num;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cin.tie(nullptr);
    cin >> n;
    while(n--){
        cin >> num;
        //if(max_heap.empty()) max_heap.push(num);
        if(max_heap.size() == min_heap.size()) max_heap.push(num);
        else min_heap.push(num);

        if(!max_heap.empty() && !min_heap.empty() && (max_heap.top() > min_heap.top())){
            int n1 = max_heap.top();
            int n2 = min_heap.top();
            max_heap.pop(); min_heap.pop();
            max_heap.push(n2); min_heap.push(n1);
        }
        cout << max_heap.top()<<'\n';
    }
    return 0;
}