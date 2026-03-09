import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive function to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition: if start >= end, all chars matched
        if (start >= end) {
            return true;
        }

        // If characters do not match, not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call: move towards the middle
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check for palindrome: ");
        String input = sc.nextLine();

        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}