import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main10 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 0, 0, 0, 0, 1, 0, 1, 1};
        List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
        System.out.println(new MaxContiguosOnes().maxone(new ArrayList<>(list), 2));
    }
}

class MaxContiguosOnes {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int k = B;
        int finalStart = 0;
        while (end < A.size()) {
            if (k > 0 || A.get(end) == 1) {
                if (A.get(end) == 0)
                    k--;
                end++;
            } else {
                if (end-start > max) {
                    max = Math.max(max, end-start);
                    finalStart = start;
                }
                while (start < A.size()) {
                    if (A.get(start) == 0)
                        k++;
                    if (k > 0 || A.get(end) == 1) {
                        finalStart = start;
                        break;
                    }
                    start++;
                }
            }
        }
        if (end-start > max) {
            max = Math.max(max, end-start);
            finalStart = start;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=finalStart; i<finalStart+max; i++) {
            result.add(i);
        }
        return result;
    }
}