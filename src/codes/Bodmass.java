package codes;

import java.util.ArrayList;
import java.util.Stack;

public class Bodmass {
    private static Boolean isOperand(char ch) { return ch >= '0' && ch <= '9'; }

    private static int digitValue(char ch) { return (int) ch - '0'; }

    private static int precedence(char oper) {
        return switch (oper) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }

    private static String removeSpaces(String s) {
        return s.replaceAll(" ", "");
    }

    private String[] toPostfix(String s) {
        s = removeSpaces(s);
        int N = s.length();
        Stack<Character> stack = new Stack<>();

        ArrayList<String> stringBuilder = new ArrayList<>();
        int i = 0, j = 0;

        while(i < N) {
            if(isOperand(s.charAt(i))) {
                StringBuilder thisNumber = new StringBuilder();
                while(i < N && isOperand(s.charAt(i))) {
                    thisNumber.append(s.charAt(i));
                    i++;
                }
                stringBuilder.add(thisNumber.toString());
            } else if(s.charAt(i) == '(') {
                stack.push(s.charAt(i++));
            } else if(s.charAt(i) == ')') {
                while(!stack.empty() && stack.peek() != '(') {
                    stringBuilder.add(stack.pop().toString());
                }
                if(stack.peek() == '(') stack.pop();
                i++;
            } else {
                while(!stack.empty() && precedence(stack.peek()) >= precedence(s.charAt(i))) {
                    stringBuilder.add(stack.pop().toString());
                }
                stack.push(s.charAt(i++));
            }
        }

        while (!stack.empty()) {
            stringBuilder.add(stack.pop().toString());
        }

        return stringBuilder.toArray(new String[0]);
    }

    public int parse(String expression) {
        String[] postfix = toPostfix(expression);
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < postfix.length) {
            if(postfix[i].length() == 1 && !isOperand(postfix[i].charAt(0))) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());

                int result = switch (postfix[i].charAt(0)) {
                    case '+' -> num1 + num2;
                    case '-' -> num1 - num2;
                    case '*' -> num1 * num2;
                    case '/' -> num1 / num2;
                    default -> 0;
                };
                stack.push(String.valueOf(result));
            } else {
                stack.push(postfix[i]);
            }
            i++;
        }
        return Integer.parseInt(stack.peek());
    }
}
