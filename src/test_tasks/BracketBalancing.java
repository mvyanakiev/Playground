package test_tasks;

import java.util.Stack;

public class BracketBalancing {
    public static void main(String[] args) {
        String input = "({()[()]})";
        boolean isBalanced = checkBracketBalance(input);
        System.out.println("Are the brackets balanced? " + isBalanced);  // Output: true
    }

    public static boolean checkBracketBalance(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
