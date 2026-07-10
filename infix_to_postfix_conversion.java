import java.util.*;

class Solution {
    public String infixToPostfix(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If operand, add to output
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }

            // If '(', push it
            else if (ch == '(') {
                st.push(ch);
            }

            // If ')', pop until '('
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop(); // Remove '('
            }

            // If operator
            else {

                while (!st.isEmpty()
                        && st.peek() != '('
                        && (precedence(st.peek()) > precedence(ch)
                        || (precedence(st.peek()) == precedence(ch) && ch != '^'))) {

                    sb.append(st.pop());
                }

                st.push(ch);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    static int precedence(char ch) {
        switch (ch) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }
}
