class Main15 {
//    1 4 3 5(n)
//    k = 3
//    2 ^ n
//    5 3 5 -> 5
//    1 7 5 -> 7
//    1 4 8 -> 8
    public static void main(String[] args) {
        int[] sweetness = new int[]{1, 4, 3, 5};
        int k = 3;
        int[][] dpArr = new int[sweetness.length][k];

        for (int i=0; i < dpArr.length; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0 || j == 0)
                    dpArr[i][j] = 0;
                else
                    dpArr[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int index=0; index < dpArr.length; index++) {
            for (int index2 = 0; index2 < k; index2++) {
                if (index == 0 || index2 == 0) {
                    if (index == 0)
                        dpArr[index][index2] = sweetness[index];
                    else if (index2 == 0) {
                        int sum = 0;
                        for (int i=0; i <= index; i++) {
                            sum += sweetness[i];
                        }
                        dpArr[index][index2] = sum;
                    }
                    continue;
                }

                int sum = sweetness[index];
                for (int j=index-1; j >= index2; j--) {
                    sum += sweetness[j];
                    dpArr[index][index2] = Math.min(
                            Math.max(dpArr[index-1][index2-1], sweetness[index]),
                            Math.max(sum, dpArr[j-1][index2])
                    );
                }
            }
        }
        System.out.println(dpArr[sweetness.length-1][k-1]);
    }
}
