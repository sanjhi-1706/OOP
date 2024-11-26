package Hello;

import java.util.Scanner;

public class exp12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter range (a b): ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.print("Enter pattern: ");
        int pattern = scanner.nextInt();

        int count = 0;
        for (int i = a; i <= b; i++) {
            if (String.valueOf(i).contains(String.valueOf(pattern))) {
                count++;
            }
        }

        System.out.println("The number of times " + pattern + " occurred between " + a + " to " + b + ": " + count);
    }
}
