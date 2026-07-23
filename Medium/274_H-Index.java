class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            // The number of papers with at least citations[i] citations
            int papers = n - i;
            if (citations[i] >= papers) {
                return papers;
            }
        }
        return 0;
    }
}
