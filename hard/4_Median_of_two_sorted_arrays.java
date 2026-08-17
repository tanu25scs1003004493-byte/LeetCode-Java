class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length)
            return findMedianSortedArrays(b, a);

        int m = a.length, n = b.length;
        int l = 0, r = m;

        while (l <= r) {
            int x = (l + r) / 2;
            int y = (m + n + 1) / 2 - x;

            int l1 = x == 0 ? Integer.MIN_VALUE : a[x - 1];
            int r1 = x == m ? Integer.MAX_VALUE : a[x];

            int l2 = y == 0 ? Integer.MIN_VALUE : b[y - 1];
            int r2 = y == n ? Integer.MAX_VALUE : b[y];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 1)
                    return Math.max(l1, l2);

                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

            if (l1 > r2)
                r = x - 1;
            else
                l = x + 1;
        }

        return 0.0;
    }
}