import java.util.*;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

// Stack-based palindrome strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String str) {
        if (str == null) return true;

        str = str.replaceAll("\\s+", "").toLowerCase(); // optional normalization
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based palindrome strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String str) {
        if (str == null) return true;

        str = str.replaceAll("\\s+", "").toLowerCase(); // optional normalization
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// PalindromeChecker using Strategy Pattern
class PalindromeChecker {
    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String str) {
        return strategy.isPalindrome(str);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check for palindrome: ");
        String input = sc.nextLine();

        System.out.println("Choose strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1/2): ");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;
        switch (choice) {
            case 1:
                strategy = new StackStrategy();
                break;
            case 2:
                strategy = new DequeStrategy();
                break;
            default:
                System.out.println("Invalid choice, defaulting to Stack Strategy.");
                strategy = new StackStrategy();
        }

        PalindromeChecker checker = new PalindromeChecker(strategy);

        if (checker.checkPalindrome(input)) {
            System.out.println("The string is a Palindrome using the chosen strategy.");
        } else {
            System.out.println("The string is NOT a Palindrome using the chosen strategy.");
        }

        sc.close();
    }
}