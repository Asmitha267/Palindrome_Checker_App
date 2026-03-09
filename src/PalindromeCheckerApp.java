import java.util.Scanner;

public class PalindromeCheckerApp {

    // Function to check palindrome ignoring spaces and case
    public static boolean isPalindrome(String str) {
        // Normalize string: remove spaces and convert to lowercase
        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check for palindrome: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string is a Palindrome (ignoring spaces & case).");
        } else {
            System.out.println("The string is NOT a Palindrome (ignoring spaces & case).");
        }

        sc.close();
    }
}