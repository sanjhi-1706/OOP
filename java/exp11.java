package Hello;

import java.util.HashSet;
import java.util.Scanner;

public class exp11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        
        if (isPerfectString(input)) {
            System.out.println("The string is a perfect string.");
        } else {
            System.out.println("The string is not a perfect string.");
        }

        scanner.close();
    }
    
    public static boolean isPerfectString(String str) {
        HashSet<Character> charSet = new HashSet<>();
        
        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                return false;
            }
        }
        
        return true;
    }
}