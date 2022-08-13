import Exceptions.ArgumentException;
import Exceptions.WrongElementException;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws WrongElementException {

        ArrayListInteger arrayListInteger = new ArrayListInteger(100_000);
//        Integer[] out = arrayListInteger.toArray();
        System.out.println(arrayListInteger.contains(250000));



//        Integer[] arr1 = Arrays.copyOf(out, 100_000);
//        Integer[] arr2 = Arrays.copyOf(out, 100_000);
//        Integer[] arr3 = Arrays.copyOf(out, 100_000);

//        arrayListInteger.sortInsertion(out);

//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
//        System.out.println(Arrays.toString(arr3));

//        long start1 = System.currentTimeMillis();
//        sortBubble(arr1);
//        System.out.println(System.currentTimeMillis()-start1);
//        System.out.println(Arrays.toString(arr1));

//        long start2 = System.currentTimeMillis();
//        sortSelection(arr2);
//        System.out.println(System.currentTimeMillis()-start2);
//        System.out.println(Arrays.toString(arr2));

//        long start3 = System.currentTimeMillis();
//        sortInsertion(arr3);
//        System.out.println(System.currentTimeMillis()-start3);
//        System.out.println(Arrays.toString(arr2));
    }

//    public static void sortBubble(Integer[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    swapElements(arr, j, j + 1);
//                }
//            }
//        }
//    }
//
//    public static void sortSelection(Integer[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minElementIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minElementIndex]) {
//                    minElementIndex = j;
//                }
//            }
//            swapElements(arr, i, minElementIndex);
//        }
//    }
//
//    public static void sortInsertion(Integer[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int temp = arr[i];
//            int j = i;
//            while (j > 0 && arr[j - 1] >= temp) {
//                arr[j] = arr[j - 1];
//                j--;
//            }
//            arr[j] = temp;
//        }
//    }
//
//    private static void swapElements(Integer[] arr, int indexA, int indexB) {
//        int tmp = arr[indexA];
//        arr[indexA] = arr[indexB];
//        arr[indexB] = tmp;
//    }

}