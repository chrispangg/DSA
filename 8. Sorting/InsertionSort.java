import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort ss = new InsertionSort();
        int[] array = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
        System.out.println(Arrays.toString(ss.insertionSort(array)));
    }
    
    public int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // while the value in front is smaller, we swap the position, then decrement by 1
            int n = i;
            while (array[n] < array[n - 1]) {
                int temp = array[n];
                array[n] = array[n - 1];
                array[n - 1] = temp;
                n--;
                if (n == 0) {
                    break;
                }
            }
        }
        return array;
    }
}
