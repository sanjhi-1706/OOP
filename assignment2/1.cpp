#include <iostream>
#include <iomanip>

using namespace std;

class Store {
private:
    static const double minerPrice;  
    static const double toasterPrice;  
    static const double fanPrice;      

public:
   
    static inline double calculateDiscountedPrice(double price, double discount) {
        return price * (1 - discount / 100);
    }


    static inline double applySalesTax(double amount, double taxRate = 10) {
        return amount * (1 + taxRate / 100);
    }

    
    double calculateTotalCost(int miners, int toasters, int fans) const {
        double minerDiscounted = calculateDiscountedPrice(minerPrice, 5);
        double toasterDiscounted = calculateDiscountedPrice(toasterPrice, 10);
        double fanDiscounted = calculateDiscountedPrice(fanPrice, 15);

        double total = (miners * minerDiscounted) + (toasters * toasterDiscounted) + (fans * fanDiscounted);

        return applySalesTax(total);
    }
};

const double Store::minerPrice = 100.0;   
const double Store::toasterPrice = 50.0;   
const double Store::fanPrice = 30.0;    

int main() {
    int miners, toasters, fans;

    cout << "Enter the number of miners: ";
    cin >> miners;
    cout << "Enter the number of toasters: ";
    cin >> toasters;
    cout << "Enter the number of fans: ";
    cin >> fans;

   
    Store store;
    double totalCost = store.calculateTotalCost(miners, toasters, fans);

    // Output the total cost
    cout << fixed << setprecision(2);
    cout << "Total amount to be paid by the store: $" << totalCost << endl;

    return 0;
}
