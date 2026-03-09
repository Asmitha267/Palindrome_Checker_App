import java.util.*;

// Iterative Array Strategy
class IterativePalindrome {
    public static boolean check(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}

// Recursive Strategy
class RecursivePalindrome {
    public static boolean check(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return check(str, start + 1, end - 1);
    }
}

// Stack-based Strategy
class StackPalindrome {
    public static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check for palindrome: ");
        String input = sc.nextLine();

        // Iterative check
        long startIterative = System.nanoTime();
        boolean resultIterative = IterativePalindrome.check(input);
        long endIterative = System.nanoTime();
        long timeIterative = endIterative - startIterative;

        // Recursive check
        long startRecursive = System.nanoTime();
        boolean resultRecursive = RecursivePalindrome.check(input, 0, input.length() - 1);
        long endRecursive = System.nanoTime();
        long timeRecursive = endRecursive - startRecursive;

        // Stack check
        long startStack = System.nanoTime();
        boolean resultStack = StackPalindrome.check(input);
        long endStack = System.nanoTime();
        long timeStack = endStack - startStack;

        // Display results
        System.out.println("\nPalindrome check results:");
        System.out.printf("Iterative Array: %s | Time: %d ns%n", resultIterative, timeIterative);
        System.out.printf("Recursive      : %s | Time: %d ns%n", resultRecursive, timeRecursive);
        System.out.printf("Stack          : %s | Time: %d ns%n", resultStack, timeStack);

        sc.close();
    }
}