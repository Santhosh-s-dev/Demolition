 class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        if (startColor == color) {
            return image;
        }
        dfs(image, sr, sc, startColor, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int startColor, int newColor) {
        int m = image.length;
        int n = image[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != startColor) {
            return;
        }

        image[r][c] = newColor;

        for (int[] d : DIRS) {
            dfs(image, r + d[0], c + d[1], startColor, newColor);
        }
    }
}