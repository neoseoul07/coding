class LongestIncreasingPathInMatrtix {
    public int longestIncreasingPath2(int[][] matrix, int row, int col, int prev, boolean[][] visited, int[][] map) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length || prev >= matrix[row][col] || visited[row][col])
            return 0;
        if (map[row][col] > 0)
            return map[row][col];
        visited[row][col] = true;

        int left = 1 + longestIncreasingPath2(matrix, row, col - 1, matrix[row][col], visited, map);
        visited = new boolean[matrix.length][matrix[row].length];
        visited[row][col] = true;
        int right = 1 + longestIncreasingPath2(matrix, row, col + 1, matrix[row][col], visited, map);
        visited = new boolean[matrix.length][matrix[row].length];
        visited[row][col] = true;
        int up = 1 + longestIncreasingPath2(matrix, row - 1, col, matrix[row][col], visited, map);
        visited = new boolean[matrix.length][matrix[row].length];
        visited[row][col] = true;
        int down = 1 + longestIncreasingPath2(matrix, row + 1, col, matrix[row][col], visited, map);
        visited = new boolean[matrix.length][matrix[row].length];
        visited[row][col] = true;
        map[row][col] = Math.max(Math.max(Math.max(left, right), up), down);
        return map[row][col];
    }
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                boolean[][] visited = new boolean[matrix.length][matrix[i].length];
                int[][] map = new int[matrix.length][matrix[i].length];
                int result = longestIncreasingPath2(matrix, i, j, -1, visited, map);
                if (max < result)
                    max = result;
            }
        }
        return max;
    }
}

class Main7 {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0][0] = 7;
        matrix[0][1] = 6;
        matrix[0][2] = 1;
        matrix[0][3] = 1;
        matrix[1][0] = 2;
        matrix[1][1] = 7;
        matrix[1][2] = 6;
        matrix[1][3] = 0;
        matrix[2][0] = 1;
        matrix[2][1] = 3;
        matrix[2][2] = 5;
        matrix[2][3] = 1;
        matrix[3][0] = 6;
        matrix[3][1] = 6;
        matrix[3][2] = 3;
        matrix[3][3] = 2;

        System.out.println(new LongestIncreasingPathInMatrtix().longestIncreasingPath(matrix));
    }
}
