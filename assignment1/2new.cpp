#include <iostream>
#include <iomanip>

using namespace std;

struct ItemCosts {
    double costMiner;
    double costToaster;
    double costFan;
    double discountMiner;
    double discountToaster;
    double discountFan;
    double salesTaxRate;
};

double Amount(int n, int m, int p, const ItemCosts costs) {
    double totalCostMiners = n * costs.costMiner;
    double totalCostToasters = m * costs.costToaster;
    double totalCostFans = p * costs.costFan;
    
    // Apply discounts
    double miners = totalCostMiners * (1 - costs.discountMiner);
    double toasters = totalCostToasters * (1 - costs.discountToaster);
    double Fans = totalCostFans * (1 - costs.discountFan);
  
    double totalcost = miners + toasters + Fans;
  
    double salesTax = totalcost * costs.salesTaxRate;

    double totalAmount = totalcost + salesTax;
    
    return totalAmount;
}

int main() {
    ItemCosts costs = {1500, 200, 450, 0.05, 0.10, 0.15, 0.10};
    
    int n, m, p;
    
    cout << "Enter the number of miners: ";
    cin >> n;
    
    cout << "Enter the number of toasters: ";
    cin >> m;
    
    cout << "Enter the number of fans: ";
    cin >> p;

    double amount = Amount(n, m, p, costs);
    cout << fixed << setprecision(2);
    cout << "The amount to be paid by the store is Rs. " << amount << endl;
    
    return 0;
}
