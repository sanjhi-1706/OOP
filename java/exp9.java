package Hello;
public class exp9 {
    public static boolean isValidPassword(String password) {
        // Check length
        if (password.length() < 5 || password.length() > 12) {
            return false;
        }

        
        boolean hasLower = false;
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') {
                hasLower = true;
            } else if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else if (c >= 'A' && c <= 'Z' || c < '0' || c > '9' && c < 'a' || c > 'z') {
                return false; // upper case or special character
            }
        }
        if (!hasLower || !hasDigit) {
            return false;
        }

        for (int i = 0; i < password.length() -1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("abc11se")); // false (upper case character)
        System.out.println(isValidPassword("123sd123")); // false (special character)
        System.out.println(isValidPassword("adfasdsdf")); // false (length too short)
        System.out.println(isValidPassword("Aasdfasd12:")); // false (length too long)
        System.out.println(isValidPassword("aaa123")); // false (same immediate pattern)
    }
}