//The approach treats the $m \times n$ 2D matrix as a virtual 1D sorted array and applies standard binary search by mapping mid-index m to 2D coordinates (m / n, m % n)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2, v = matrix[mid / n][mid % n];
            if (v == target) return true;
            if (v < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}