import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] array = new int[] { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0, 30 };
        System.out.println(Arrays.toString(qs.quickSort(array)));
    }

    public int[] quickSort(int[] array) {
        if (array.length == 1) {
            return array;
        } else if (array.length == 2) {
            if (array[0] > array[1]) {
                int temp = array[0];
                array[0] = array[1];
                array[1] = temp;
            }
            return array;
        } else {
            int pivot = array[array.length - 1];
            int leftpr = 0;
            int rightpr = array.length - 2;

            // left < pivot < right
            while (leftpr < rightpr) {
                // when both side are in the wrong position
                if (array[leftpr] > pivot && array[rightpr] < pivot) {
                    int temp = array[leftpr];
                    array[leftpr] = array[rightpr];
                    array[rightpr] = temp;
                    leftpr++;
                    // when only the right side is wrong
                } else if (array[leftpr] < pivot && array[rightpr] < pivot) {
                    leftpr++;
                    // when only the left side is wrong
                } else if (array[leftpr] > pivot && array[rightpr] > pivot) {
                    rightpr--;
                } else {
                    leftpr++;
                }
            }

            // swap leftpr element with pivot element if the array[left] > pivotval
            if(array[leftpr] > pivot){
                int temp = array[leftpr];
                array[leftpr] = array[array.length - 1];
                array[array.length - 1] = temp;
            }
            
            // print sorted
            System.out.println("Sorted: " + Arrays.toString(array));
            // break the array into three parts

            int[] left = Arrays.copyOfRange(array, 0, leftpr);
            int pivotval = array[leftpr];
            int[] right = Arrays.copyOfRange(array, leftpr + 1, array.length);
            System.out.print("left: " + Arrays.toString(left));
            System.out.print(" pivot: " + pivotval);
            System.out.println(" right: " + Arrays.toString(right));
            System.out.println(" ");
            return merge(quickSort(left), pivotval, quickSort(right));
        }
    }

    public int[] merge(int[] left, int pivotval, int[] right) {
        int combinedLength = left.length + right.length + 1;
        System.out.println("left: "+  Arrays.toString(left));
        System.out.println("pivotval: " + pivotval );
        System.out.println("right: " + Arrays.toString(right));

        int[] combined = new int[combinedLength];
        System.arraycopy(left, 0, combined, 0, left.length);
        combined[left.length] = pivotval;
        System.arraycopy(right, 0, combined, left.length + 1, right.length);

        System.out.println("combined: " + Arrays.toString(combined));
        return combined;
    }
}
