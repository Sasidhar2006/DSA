import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prev = prevSmallerIndex(arr);
        int[] next = nextSmallerIndex(arr);
        
        long total = 0;
        long mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            
            long left = i - prev[i];
            long right = next[i] - i;
            
            
            total = (total + (left * right * arr[i])) % mod;
        }
        return (int) total;
    }

    private int[] prevSmallerIndex(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
          
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    private int[] nextSmallerIndex(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
           
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }
}
