package Sorting;
import java.util.Arrays;

class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0 };

        BubbleSort bs = new BubbleSort();
        int[] sortednums = bs.bubbleSort(numbers);
        System.out.println(Arrays.toString(sortednums));
    }

    // Loop through the array. If the value arr[i] > arr[i+1] , swap the places of
    // the two positions. Keep going until the end of the loop. Restart the loop
    // until we reach n-1, where n is the position of where it stopped in the last
    // loop
    public int[] bubbleSort(int[] array) {
        int n = array.length;
        while (n > 0) {
            for (int i = 1; i < n; i++) {
                if (array[i] < array[i - 1]) {
                    int swapnum = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = swapnum;
                }
            }
            n--;
        }
        return array;
    }
}