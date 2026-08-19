class Solution {
    public int lowerBound(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= 1) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return arr.length - ans;
    }

    public int rowWithMax1s(int[][] mat) {
        int cntMax = 0;
        int index = -1;

        for (int i = 0; i < mat.length; i++) {
            int cntOnes = lowerBound(mat[i]);

            if (cntOnes > cntMax) {
                cntMax = cntOnes;
                index = i;
            }
        }

        return index;
    }
}
