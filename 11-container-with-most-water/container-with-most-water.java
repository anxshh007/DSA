class Solution {
    public int maxArea(int[] h) {
        int l=0, r=h.length-1;
        int ans=0;

        while (l<r) {
            int a = Math.min(h[l], h[r]) * (r-l);
            ans = Math.max(ans,a);

            if (h[l] < h[r])
                l++;
            else
                r--;
        }
        return ans;
    }
}