#include <iostream>
#include <climits> // For INT_MIN
using namespace std;

class Array {
private:
    int* arr;        
    int size;        

public:
    
    Array() : arr(nullptr), size(0) {}

 
    Array(int arraySize) : size(arraySize) {
        arr = new int[size]; 
        cout << "Enter " << size << " elements:\n";
        for (int i = 0; i < size; ++i) {
            cin >> arr[i]; 
        }
    }


    Array(int* inputArray, int arraySize) : size(arraySize) {
        arr = new int[size];  
        for (int i = 0; i < size; ++i) {
            arr[i] = inputArray[i];
        }
    }

    ~Array() {
        delete[] arr;
    }

    int findLargest() const {
        if (size == 0) {
            cerr << "Array is empty.\n";
            return INT_MIN; 
        }

        int largest = arr[0];
        for (int i = 1; i < size; ++i) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
};

int main() {
   
    int size;
    cout << "Enter the size of the array: ";
    cin >> size;
    
    Array array1(size); 
    cout << "The largest element in the array is: " << array1.findLargest() << endl;

    int existingArray[] = {10, 20, 30, 40, 50};
    int existingSize = sizeof(existingArray) / sizeof(existingArray[0]);

    Array array2(existingArray, existingSize); 
    cout << "The largest element in the existing array is: " << array2.findLargest() << endl;

    return 0;
}
