import java.util.Stack;

class MaxRectangleInMatrix {
    public int maxArea(int[] arr) {
        if (arr.length == 0)
            return 0;
        Stack<Integer> s = new Stack<Integer>();
        int currIndex = 0;
        int curr;
        int maxArea = Integer.MIN_VALUE;
        int tempIndex;
        int area;
        while(currIndex < arr.length) {
            curr = arr[currIndex];
            while (!s.isEmpty() && curr <= arr[s.peek()]) {
                tempIndex = s.pop();
                if (s.isEmpty())
                    area = arr[tempIndex] * currIndex;
                else
                    area = arr[tempIndex] * (currIndex - s.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            s.push(currIndex);
            currIndex++;
        }
        while (!s.isEmpty()) {
            tempIndex = s.pop();
            if (s.isEmpty())
                area = arr[tempIndex] * arr.length;
            else
                area = arr[tempIndex] * (arr.length - s.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int[][] matrix2 = new int[matrix.length][matrix[0].length];
        int maxRectange = Integer.MIN_VALUE;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (i == 0) {
                    matrix2[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
                    continue;
                }
                if (matrix[i][j] == '1')
                    matrix2[i][j] = 1 + matrix2[i-1][j];
            }
            maxRectange = Math.max(maxRectange, maxArea(matrix2[i]));
        }
        return maxRectange;
    }
}

class Main9 {
    public static void main(String[] args) {
        System.out.println(new MaxRectangleInMatrix().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
//        System.out.println(new MaxRectangleInMatrix().maxArea(new int[]{0, 2, 1, 1}));
    }
}
