import java.util.Arrays;

class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray s = new MergeSortedArray();
        int[] arr1 = { 0, 3, 4 };
        int[] arr2 = { 4, 6, 30, 7,8,9 };
        System.out.println(s.mergeSortedArray(arr1, arr2));
    }

    //use forloop to merge sorted Array
    public int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(result));

        return result;
    }
}