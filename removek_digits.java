import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
      
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            if (sb.length() == 0 && c == '0') continue;
            sb.append(c);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
