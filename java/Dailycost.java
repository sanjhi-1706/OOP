package Hello;

import java.util.Scanner;

class GetInput {
    double totalMiles;
    double gallonCost;
    double feesPerDay;
    double tollPerDay;
    final int milesPerGallon = 30;

    GetInput() {
        totalMiles = 0.0;
        gallonCost = 0.0;
        feesPerDay = 0.0;
        tollPerDay = 0.0;
    }

    void get() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Total number of miles: ");
        totalMiles = scanner.nextDouble();

        System.out.print("Enter the cost per gallon of gasoline: ");
        gallonCost = scanner.nextDouble();

        System.out.print("Enter the average fees per day: ");
        feesPerDay = scanner.nextDouble();

        System.out.print("Enter the tolls per day: ");
        tollPerDay = scanner.nextDouble();
        
       // scanner.close();
    }

    double calculate() {
        return (totalMiles / milesPerGallon) * gallonCost + feesPerDay + tollPerDay;
    }
}

public class Dailycost {

    public static void main(String[] args) {
        GetInput input = new GetInput();
        input.get();
        double dailyCost = input.calculate();
        System.out.printf("Your daily driving cost is: %.2f", dailyCost);
    }
}
