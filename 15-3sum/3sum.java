class Solution {
    public List<List<Integer>> threeSum(int[] a) {

        List<List<Integer>> r = new ArrayList<>();
        Arrays.sort(a);

        for (int i =0; i<a.length - 2; i++) {
            if (i>0 && a[i] == a[i-1]) continue;
            if (a[i] > 0 ) break;

            int l = i+1, h=a.length - 1;

            while (l<h) {
                int x = a[i] + a[l] + a[h];

                if (x==0) {
                    r.add(Arrays.asList(a[i], a[l], a[h]));

                    while (l < h && a[l] == a[l+1]) l++;
                    while (l < h && a[l] == a[h - 1]) h--;

                    l++;
                    h--;
                } 

                else if (x<0) {
                    l++;
                }
                else {
                    h--;
                }

            }
        }

        return r;
        
    }
}