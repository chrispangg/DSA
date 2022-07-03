import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr;
        } else if (n % 2 == 0) {
            int[] left = Arrays.copyOfRange(arr, 0, n / 2);
            int[] right = Arrays.copyOfRange(arr, n / 2, n);
            System.out.println("left: " + Arrays.toString(left) + " and right: " + Arrays.toString(right));
            return merge(mergeSort(left), mergeSort(right));
        } else if (n % 2 == 1) {
            int[] left = Arrays.copyOfRange(arr, 0, (n + 1) / 2);
            int[] right = Arrays.copyOfRange(arr, (n + 1) / 2, n);
            System.out.println("left: " + Arrays.toString(left) + " and right: " + Arrays.toString(right));
            return merge(mergeSort(left), mergeSort(right));
        }

        return arr;
    }

    public int[] merge(int[] left, int[] right) {
        int leftlen = 0;
        int rightlen = 0;
        int combinedlen = left.length + right.length;
        int[] combined = new int[combinedlen];
        for (int i = 0; i < combined.length; i++) {
            if (leftlen == left.length && rightlen != right.length) {
                combined[i] = right[rightlen];
                rightlen++;
            } else if (rightlen == right.length && leftlen != left.length) {
                combined[i] = left[leftlen];
                leftlen++;
            } else if (right[rightlen] < left[leftlen]) {
                combined[i] = right[rightlen];
                rightlen++;
            } else if (right[rightlen] > left[leftlen]) {
                combined[i] = left[leftlen];
                leftlen++;
            }
        }

        return combined;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] array = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
        System.out.println(Arrays.toString(ms.mergeSort(array)));
    }
}
