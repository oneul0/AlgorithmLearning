#include <iostream>
#include <functional>

// 델리게이트를 활용한 간단한 예제
class DelegateExample {
public:
    // 델리게이트 타입 정의
    using Delegate = std::function<void(int)>;

    // 델리게이트를 저장하는 멤버 변수
    Delegate delegate;

    // 델리게이트 호출하는 함수
    void InvokeDelegate(int value) {
        if (delegate) {
            delegate(value);
        }
    }
};

int main() {
    DelegateExample example;

    // 델리게이트에 람다 함수 등록
    example.delegate = [](int value) {
        std::cout << "델리게이트가 호출되었습니다: " << value << std::endl;
    };

    // 델리게이트 호출
    example.InvokeDelegate(42);

    return 0;
}
