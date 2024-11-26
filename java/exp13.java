package Hello;
interface Function {
    int evaluate(int value);
}

class Half implements Function {
    @Override
    public int evaluate(int value) {
        return value / 2;   
    }
}

public class exp13 {
    public static int[] halveArray(int[] input) {
        int[] result = new int[input.length];
        Function halfFunction = new Half(); 
        
        // Iterate over the input array and populate the result array
        for (int i = 0; i < input.length; i++) {
            result[i] = halfFunction.evaluate(input[i]);
        }
        
        return result; 
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int[] halvedNumbers = halveArray(numbers);
       
        // Print the results
        for (int num : halvedNumbers) {
            System.out.println(num);
        }
    }
}
