#include <iostream>

class Matrix {
private:
    int rows;
    int cols;
    double** data;

public:
    Matrix(int rows, int cols) {
        this->rows = rows;
        this->cols = cols;
        data = new double*[rows];
        for (int i = 0; i < rows; i++) {
            data[i] = new double[cols];
        }
    }

    ~Matrix() { //destuctor
        for (int i = 0; i < rows; i++) {
            delete[] data[i];
        }
        delete[] data;
    }

    void setElement(int row, int col, double value) {
        data[row][col] = value;
    }

    double getElement(int row, int col) {
        return data[row][col];
    }

    Matrix add(Matrix& other) {
        if (rows != other.rows || cols != other.cols) {
            std::cerr << "Matrix dimensions do not match for addition." << std::endl;
            exit(1);
        }

        Matrix result(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, getElement(i, j) + other.getElement(i, j));
            }
        }
        return result;
    }

    void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                std::cout << getElement(i, j) << " ";
            }
            std::cout << std::endl;
        }
    }
};

int main() {
    Matrix m1(2, 2);
    m1.setElement(0, 0, 1.0);
    m1.setElement(0, 1, 2.0);
    m1.setElement(1, 0, 3.0);
    m1.setElement(1, 1, 4.0);

    Matrix m2(2, 2);
    m2.setElement(0, 0, 5.0);
    m2.setElement(0, 1, 6.0);
    m2.setElement(1, 0, 7.0);
    m2.setElement(1, 1, 8.0);

    Matrix result = m1.add(m2);

    std::cout << "Matrix 1:" << std::endl;
    m1.display();

    std::cout << "Matrix 2:" << std::endl;
    m2.display();

    std::cout << "Resultant Matrix:" << std::endl;
    result.display();

    return 0;
}