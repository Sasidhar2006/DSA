public class Solution {
    public boolean isPossible(long barrier, int[] nums, int A, int B) {
        long currentPainters = 1;
        long currentPaint = 0;

        for (int i = 0; i < nums.length; i++) {
            long boardTime = (long) nums[i] * B;
            
            // If a single board takes more than the barrier, it is impossible
            if (boardTime > barrier) {
                return false;
            }

            // If adding this board exceeds the barrier, assign a new painter
            if (currentPaint + boardTime > barrier) {
                currentPainters++;
                currentPaint = boardTime;
            } else {
                currentPaint += boardTime;
            }
        }

        return currentPainters <= A;
    }

    public int paint(int A, int B, int[] C) {
        long low = 0;
        long high = 0;
        long mod = 10000003; // Standard modulo often used in this problem (e.g., Interviewbit)

        for (int num : C) {
            low = Math.max(low, num);
            high += num;
        }

        low = low * B;
        high = high * B;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(mid, C, A, B)) {
                ans = mid;
                high = mid - 1; // Try to find a smaller maximum time
            } else {
                low = mid + 1;  // Increase the barrier time
            }
        }

        return (int) (ans % mod);
    }
}
