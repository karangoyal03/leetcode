class Solution {
    public int findContentChildren(int[] g, int[] s) {
    int gKiLength = g.length;
    int sKiLength = s.length;

    int l = 0;
    int r = 0;

    Arrays.sort(g);
    Arrays.sort(s);

    while (l < sKiLength && r < gKiLength) {
        if (g[r] <= s[l]) {
            r++;
        }
        l++;
    }

    return r;

    }

}