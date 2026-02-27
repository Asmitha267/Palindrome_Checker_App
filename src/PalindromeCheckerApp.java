import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    // Method to check palindrome using Queue + Stack
    public static boolean isPalindrome(String input) {

        Stack<Character> stack = new Stack<>();       // LIFO
        Queue<Character> queue = new LinkedList<>();  // FIFO

        // Fill both data structures
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);   // push to stack
            queue.add(ch);    // enqueue to queue
        }

        // Compare stack pop vs queue dequeue
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.remove()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC6: Queue + Stack Based) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a palindrome.");
        }

        scanner.close();
    }
}