#include <iostream>
using namespace std;


int main() {
    int size = 5;
    int* array = new int[size];

    if (array == nullptr) {
        cout << "Memory allocation failed!" << endl;
        return 1;
    }

    for (int i = 0; i < size; ++i) {
        array[i] = i ;
    }

    cout << "Array contents:" << endl;
    for (int i = 0; i < size; ++i) {
        cout << array[i] << " ";
    }
    cout << endl;

    delete[] array;
    array = nullptr;

    return 0;
}





   
