import java.io.IOException;

/**
 * Created by yaswanth on 27/02/19.
 */
class Main2 {
    public static void main(String[] args) throws IOException {
        System.out.println(new LongestPalindromeSubString().longestPalindrome("bbbd"));
    }
}

class LongestPalindromeSubString {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0)
            return "";
        boolean[][] arr = new boolean[n][n];
        for (int i=0; i<n; i++) {
            arr[i][i] = true;
        }
        int start = 0,end = 0;
        for (int j=0; j<n; j++) {
            for (int i=0; i<n; i++) {
                if ((j-i == 1 || (i+1 <= j-1 && arr[i+1][j-1])) && s.charAt(i) == s.charAt(j)) {
                    arr[i][j] = true;
                    if (j-i > end-start) {
                        start = i;
                        end = j;
                    }
                } else if (i != j){
                    arr[i][j] = false;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}