package com.bytebybyte.stackusages;

import java.util.Arrays;
import java.util.Stack;

public class InfixExpressionsToPostFixExample {


    public static void main(String[] args) {
        //System.out.println(convertInfixToPostfix("A+B*C+D*E"));
        //System.out.println(convertInfixToPostfixWithParanthesis("(A+(B*C)+(D*E))"));

        String postFixString = convertInfixToPostfix("4+5*8+6*7");
        System.out.println(postFixString);
        System.out.print("Result: " + evaluatePostFixExpressions(postFixString));
    }

    private static boolean checkForOpeningBrackets(Character c) {
        final Character[] OPENING_BRACKETS = {'{', '(', '['};
        return Arrays.stream(OPENING_BRACKETS).anyMatch(c::equals);
    }

    private static boolean checkForClosingBrackets(char c) {
        final char[] CLOSING_BRACKETS = {'}', ')', ']'};

        for (char tempChar : CLOSING_BRACKETS) {
            if (tempChar == c) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkForOperator(Character c) {
        final Character[] OPENING_BRACKETS = {'+', '-', '*', '/'};
        return Arrays.stream(OPENING_BRACKETS).anyMatch(c::equals);
    }

    private static int compareOperators(Character oper1, Character oper2) {
        // Rules
        // +, -  = equal = return 0
        // *, /  = equal = return 0
        // (*, /) or (+, -) = return 1  //operator1 has precedence over operator2
        // (+, -) or (*, /) = return -1  //operator1 has less precedence over operator2

        if ((oper1 == oper2)
                || (oper1 == '+' && oper2 == '-')
                || (oper1 == '-' && oper2 == '+')
                || (oper1 == '*' && oper2 == '/')
                || (oper1 == '/' && oper2 == '*')) {
            return 0;
        }

        if ((oper2 == '+' || oper2 == '-') && (oper1 == '*' || oper1 == '/')) {
            return 1;
        } else {
            return -1;
        }


    }

    // Only Operators and Operands
    public static String convertInfixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        int length = expression.length();
        Character c;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            c = Character.valueOf(expression.charAt(i));

            // case 1: c can be an operator
            // case 2: c can be an operand

            if (!checkForOperator(c)) {
                builder.append(c);
            } else {
                while (!stack.isEmpty() && compareOperators(stack.peek(), c) >= 0) {
                    builder.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);

            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    // Only Operators and Operands
    public static String convertInfixToPostfixWithParanthesis(String expression) {
        Stack<Character> stack = new Stack<>();
        int length = expression.length();
        Character c;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            c = Character.valueOf(expression.charAt(i));

            // case 1: c can be an operator
            // case 2: c can be an operand
            // case 3: c is opening bracket
            // case 4: c is closing bracket

            if (!checkForOperator(c) && !checkForOpeningBrackets(c) && !checkForClosingBrackets(c)) {
                builder.append(c);
            } else if(checkForOperator(c)) {
                while (!stack.isEmpty() && compareOperators(stack.peek(), c) >= 0
                        && !checkForOpeningBrackets(stack.peek())) {
                    builder.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            } else if(checkForOpeningBrackets(c)) {
                stack.push(c);
            } else if(checkForClosingBrackets(c)) {
                while (!stack.isEmpty()  && !checkForOpeningBrackets(stack.peek())) {
                    builder.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    public static int evaluatePostFixExpressions(String expression){
        int length = expression.length();
        Character c;
        int operand1, operand2;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<length; i++) {
            c = expression.charAt(i);

            if(!checkForOperator(c)) {
                stack.push(Integer.parseInt(""+ c));
            } else {
                operand1 = stack.pop();
                operand2 = stack.pop();
                int tempResult = performOperation(operand1, operand2, c);
                stack.push(tempResult);
            }
        }
        return stack.pop();
    }

    private static int performOperation(int operand1, int operand2, Character operation) {
        switch (operation) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                return 0;
        }
    }
}
