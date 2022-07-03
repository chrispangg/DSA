import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] array = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };
        System.out.println(Arrays.toString(ss.selectionSort(array)));
    }

    public int[] selectionSort(int[] array) {
        int inc = 0;
        while (inc < array.length) {
            int smallest = array[inc];
            int pos = inc;
            for (int j = inc; j < array.length; j++) {
                if (array[j] < smallest) {
                    smallest = array[j];
                    pos = j;
                }
            }
            int temp;
            temp = array[inc];
            array[inc] = smallest;
            array[pos] = temp;
            inc++;
        }
        return array;
    }
}
