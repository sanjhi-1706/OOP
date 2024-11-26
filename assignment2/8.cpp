#include <iostream>
#include <iomanip>

using namespace std;

class BankAccount {
private:
    int accountNumber;
    double balance;

public:
    BankAccount(int accNum, double initialBalance) 
        : accountNumber(accNum), balance(initialBalance) {}

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            cout << "Deposited: $" << fixed << setprecision(2) << amount << endl;
        } else {
            cout << "Invalid deposit amount." << endl;
        }
    }

    void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                cout << "Withdrew: $" << fixed << setprecision(2) << amount << endl;
            } else {
                cout << "Insufficient funds." << endl;
            }
        } else {
            cout << "Invalid withdrawal amount." << endl;
        }
    }

    void checkBalance() const {
        cout << "Account Number: " << accountNumber << endl;
        cout << "Current Balance: $" << fixed << setprecision(2) << balance << endl;
    }
};

int main() {
    int accNum;
    double initialBalance;

    cout << "Enter account number: ";
    cin >> accNum;

    cout << "Enter initial balance: $";
    cin >> initialBalance;

    BankAccount account(accNum, initialBalance);

    char choice;
    do {
        cout << "\nMenu:\n";
        cout << "1. Deposit\n";
        cout << "2. Withdraw\n";
        cout << "3. Check Balance\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case '1': {
                double depositAmount;
                cout << "Enter deposit amount: $";
                cin >> depositAmount;
                account.deposit(depositAmount);
                break;
            }
            case '2': {
                double withdrawAmount;
                cout << "Enter withdrawal amount: $";
                cin >> withdrawAmount;
                account.withdraw(withdrawAmount);
                break;
            }
            case '3':
                account.checkBalance();
                break;
            case '4':
                cout << "Exiting...\n";
                break;
            default:
                cout << "Invalid choice. Please try again.\n";
        }
    } while (choice != '4');

    return 0;
}
