public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // Original String with mixed case
        String original = "Madam";

        // Convert to lowercase to ignore case sensitivity
        String lowerCaseString = original.toLowerCase();

        String reversed = "";

        // Reverse string
        for (int i = lowerCaseString.length() - 1; i >= 0; i--) {
            reversed = reversed + lowerCaseString.charAt(i);
        }

        // Compare
        if (lowerCaseString.equals(reversed)) {
            System.out.println("The string \"" + original + "\" is a Palindrome (Case-Insensitive).");

        } else {
            System.out.println("The string \"" + original + "\" is NOT a Palindrome.");
        }
    }
}
