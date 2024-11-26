#include <iostream>

using namespace std;

class Integer {
private:
    int i;

public:
     Integer(){
        i=0;
     }

    friend void operator<<(ostream &os, Integer &obj){
       os << obj.i;
    }
    friend void operator>>(istream &is, Integer &obj){
        is >> obj.i;
    }
};

int main() {
    Integer num;

    cout << "Enter an integer i: ";
    cin>> num;

    cout << "The integer i you entered is: " << num ;

    return 0;
}
