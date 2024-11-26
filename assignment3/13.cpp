#include <iostream>
using namespace std;

class integer {
private:
    int value;

public:
    integer(int a){
        value=a;
    }

    friend integer operator+(integer a, integer b);

    void display() {
        cout << value;
    }
};

integer operator+(integer a, integer b) {
    return a.value + b.value;
}

int main() {
    integer num1(10);
    integer num2(20);

    integer result = num1 + num2;

    result.display();
    return 0;
}
