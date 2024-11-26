#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Item {
protected:
    string title;
    double price;

public:
    Item(string itemTitle = "", double itemPrice = 0.0)
        : title(itemTitle), price(itemPrice) {}

    string getTitle() {
        return title;
    }

    double getPrice() {
        return price;
    }
};

class Book : public Item {
private:
    string author;

public:
    Book(string bookTitle = "", double bookPrice = 0.0, string bookAuthor = "")
        : Item(bookTitle, bookPrice), author(bookAuthor) {}

    string getAuthor() {
        return author;
    }
};

class Journal : public Item {
private:
    string editor;

public:
    Journal(string journalTitle = "", double journalPrice = 0.0, string journalEditor = "")
        : Item(journalTitle, journalPrice), editor(journalEditor) {}

    string getEditor() {
        return editor;
    }
};

class Library {
private:
    vector<Book> books;
    vector<Journal> journals;

public:
    void addBook() {
        string title, author;
        double price;
        cout << "Enter book title: ";
        getline(cin, title);
        cout << "Enter book author: ";
        getline(cin, author);
        cout << "Enter book price: ";
        cin >> price;
        cin.ignore();
        books.push_back(Book(title, price, author));
    }

    void addJournal() {
        string title, editor;
        double price;
        cout << "Enter journal title: ";
        getline(cin, title);
        cout << "Enter journal editor: ";
        getline(cin, editor);
        cout << "Enter journal price: ";
        cin >> price;
        cin.ignore();
        journals.push_back(Journal(title, price, editor));
    }

    void listBooks() {
        cout << "Books in the library:\n";
        for (Book book : books) {
            cout << "Title: " << book.getTitle() << ", Author: " << book.getAuthor() << ", Price: $" << book.getPrice() << endl;
        }
    }

    void listJournals() {
        cout << "Journals in the library:\n";
        for (Journal journal : journals) {
            cout << "Title: " << journal.getTitle() << ", Editor: " << journal.getEditor() << ", Price: $" << journal.getPrice() << endl;
        }
    }
};

int main() {
    Library library;
    int choice;

    while (true) {
        cout << "\nLibrary Menu:\n";
        cout << "1. Add Book\n";
        cout << "2. Add Journal\n";
        cout << "3. List Books\n";
        cout << "4. List Journals\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;
        cin.ignore();

        switch (choice) {
            case 1:
                library.addBook();
                break;
            case 2:
                library.addJournal();
                break;
            case 3:
                library.listBooks();
                break;
            case 4:
                library.listJournals();
                break;
            case 5:
                return 0;
            default:
                cout << "Invalid choice. Please try again.\n";
        }
    }

    return 0;
}
