#include <iostream>
#include <vector>
#include <string>
#include <limits>

using namespace std;

class Book {
private:
    string title;
    string subject;
    double price;

public:
    Book(string bookTitle = "", string bookSubject = "", double bookPrice = numeric_limits<double>::max())
        : title(bookTitle), subject(bookSubject), price(bookPrice) {}

    string getTitle() {
        return title;
    }

    string getSubject() {
        return subject;
    }

    double getPrice() {
        return price;
    }
};

class Library {
private:
    vector<Book> books;

public:
    void addBook(Book book) {
        books.push_back(book);
    }

    Book findCheapestBook(string subject) {
        Book cheapestBook;
        bool found = false;

        for (Book &book : books) {
            if (book.getSubject() == subject && book.getPrice() < cheapestBook.getPrice()) {
                cheapestBook = book;
                found = true;
            }
        }

        if (!found) {
            cheapestBook = Book("No book found", "", numeric_limits<double>::max());
        }

        return cheapestBook;
    }
};

int main() {
    Library library;

    library.addBook(Book("Introduction to Algorithms", "Computer Science", 55.00));
    library.addBook(Book("Data Structures and Algorithms", "Computer Science", 45.00));
    library.addBook(Book("Modern Physics", "Physics", 60.00));
    library.addBook(Book("Quantum Mechanics", "Physics", 50.00));

    string subject;
    cout << "Enter the subject to find the cheapest book: ";
    getline(cin, subject);

    Book cheapestBook = library.findCheapestBook(subject);
    if (cheapestBook.getTitle() == "No book found") {
        cout << "No books found on " << subject << "." << endl;
    } else {
        cout << "The cheapest book on " << subject << " is \"" 
             << cheapestBook.getTitle() << "\" priced at $" 
             << cheapestBook.getPrice() << endl;
    }

    return 0;
}
