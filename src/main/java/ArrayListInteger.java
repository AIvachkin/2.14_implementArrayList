import Exceptions.InvalidIndexException;
import Exceptions.StorageIsFullException;
import Exceptions.WrongElementException;

import java.util.Arrays;

public class ArrayListInteger {
    private Integer[] arr;
    private int size;

    public ArrayListInteger(int size) {
        java.util.Random random = new java.util.Random();
        arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1_000_000) + 1;
        }
    }

    public void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public void sortRecursion(Integer[] arr) {
        mergeSort(arr);
    }

    public static void mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }

    public boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (item == arr[mid]) {
                return true;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }


    public boolean contains(Integer item) {
        Integer[] arrCopy = toArray(7);
//        sortInsertion(arrCopy);
        sortInsertion(arrCopy);
        return binarySearch(arrCopy, item);

    }

    public Integer add(Integer item) {

        validateItem(item);

        if (size == arr.length) {
            int newLength = (int) (arr.length * 1.5);
            grow(newLength);
        }
//        validateSize();
        arr[size++] = item;
        return item;
    }

    public void grow(int newLength) {
        Integer[] newArrayListInteger = new Integer[newLength];
        System.arraycopy(arr, 0, newArrayListInteger, 0, arr.length);
        arr = newArrayListInteger;

    }

    public Integer add(int index, Integer item) {

        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            arr[size++] = item;
            return item;
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
        return item;
    }

    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);

        arr[index] = item;
        return item;
    }

    public Integer remove(Integer item) {

        validateItem(item);

        int index = indexOf(item);
        if (index == -1) {
            throw new WrongElementException();
        }

        return removeByIndex(index);
    }

    public Integer removeByIndex(int index) {

        validateIndex(index);

        Integer item = arr[index];
        if (index != size) {
            System.arraycopy(arr, index + 1, arr, index, size - index);
        }
        size--;
        return item;
    }


    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        validateIndex(index);
        return arr[index];
    }

//    public boolean equals(StringList otherList) throws ArgumentException {
//        return Arrays.equals(this.toArray(), otherList.toArray());
//    }

    public int size() {

        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }


    public void clear() {

        size = 0;
    }

    private void validateItem(Integer item) throws WrongElementException {
        if (item == null) {
            throw new WrongElementException("Введено нулевое значение элемента массива");
        }
    }

    private void validateSize() {
        if (size == arr.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    public Integer[] toArray(int size) {
        return Arrays.copyOf(arr, size);
    }

    @Override
    public String toString() {

        return Arrays.toString(arr);
    }
}
