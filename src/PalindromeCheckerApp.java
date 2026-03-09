import java.util.Scanner;

// Encapsulated Palindrome Checker class
class PalindromeChecker {

    // Method to check palindrome using array (iterative)
    public boolean checkPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Optional: Can add other methods like recursiveCheckPalindrome(String str) if needed
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check for palindrome: ");
        String input = sc.nextLine();

        // Use PalindromeChecker service
        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(input)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}