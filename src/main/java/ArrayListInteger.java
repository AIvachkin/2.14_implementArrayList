import Exceptions.ArgumentException;
import Exceptions.InvalidIndexException;
import Exceptions.StorageIsFullException;
import Exceptions.WrongElementException;

import java.util.Arrays;

public class ArrayListInteger {
    private final Integer[] arrayListInteger;
    private int size;

    public ArrayListInteger(int size) {
        java.util.Random random = new java.util.Random();
        arrayListInteger = new Integer[size];
        for (int i = 0; i < arrayListInteger.length; i++) {
            arrayListInteger[i] = random.nextInt(1_000_000) + 1;
        }
    }

    public Integer add(Integer item) {

        validateSize();
        validateItem(item);
        arrayListInteger[size++] = item;
        return item;
    }


    public Integer add(int index, Integer item) {

        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            arrayListInteger[size++] = item;
            return item;
        }
        System.arraycopy(arrayListInteger, index, arrayListInteger, index + 1, size - index);
        arrayListInteger[index] = item;
        size++;
        return item;
    }

    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);

        arrayListInteger[index] = item;
        return item;
    }

    public Integer remove(Integer item) {

        validateItem(item);

        int index = indexOf(item);
        if (index == -1) {
            throw new WrongElementException();
        }

        return remove(index);
    }

    public Integer remove(int index) {

        validateIndex(index);

        Integer item = arrayListInteger[index];
        if (index != size) {
            System.arraycopy(arrayListInteger, index + 1, arrayListInteger, index, size - index);
        }
        size--;
        return item;
    }

    public boolean contains(Integer item) {
        return indexOf(item) > -1;
    }

    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (arrayListInteger[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayListInteger[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        validateIndex(index);
        return arrayListInteger[index];
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
        if (size == arrayListInteger.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    public Integer[] toArray() {
        return Arrays.copyOf(arrayListInteger, 10);
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayListInteger);
    }
}
