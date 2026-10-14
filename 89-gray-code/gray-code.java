//The approach generates the n-bit Gray code sequence by applying the standard bitwise formula i ^ (i >> 1) for every integer from 0 to 2^n - 1, ensuring adjacent values differ by only one bit.

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) l.add(i ^ i >> 1);
        return l;
    }
}