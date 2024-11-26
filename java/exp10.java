package Hello;
import java.util.HashMap;
import java.util.Scanner;

public class exp10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        System.out.println("Characters that occur more than " + n + " times:");
        for (HashMap.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > n) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        scanner.close();
    }
}
