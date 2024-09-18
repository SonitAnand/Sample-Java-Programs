package org.example.sample2;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {

        String input = "[()]{}{[()()]()}";
        boolean result = checkBalancedBrackets(input);
        System.out.println("are balanced brackets - " + result);
    }

    private static boolean checkBalancedBrackets(String input) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                characterStack.push(input.charAt(i));
                continue;
            }
            if (characterStack.isEmpty()) return false;
            char temp;
            switch (input.charAt(i)) {
                case ')':
                    temp = characterStack.pop();
                    if (temp != '(') {
                        return false;
                    }
                    break;
                case '}':
                    temp = characterStack.pop();
                    if (temp != '{') {
                        return false;
                    }
                    break;
                case ']':
                    temp = characterStack.pop();
                    if (temp != '[') {
                        return false;
                    }
                    break;
            }
        }
        return characterStack.isEmpty();
    }
}
